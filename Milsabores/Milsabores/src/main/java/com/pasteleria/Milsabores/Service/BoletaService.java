package com.pasteleria.Milsabores.Service;

import com.pasteleria.Milsabores.DTO.BoletaRequestDTO;
import com.pasteleria.Milsabores.DTO.DetalleBoletaRequestDTO;
import com.pasteleria.Milsabores.Entity.Boleta;
import com.pasteleria.Milsabores.Entity.DetalleBoleta;
import com.pasteleria.Milsabores.Entity.Pastel;
import com.pasteleria.Milsabores.Entity.Usuario;
import com.pasteleria.Milsabores.Repository.BoletaRepository;
import com.pasteleria.Milsabores.Repository.DetalleBoletaRepository;
import com.pasteleria.Milsabores.Repository.PastelRepository;
import com.pasteleria.Milsabores.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoletaService {

    @Autowired
    private BoletaRepository boletaRepository;

    @Autowired
    private DetalleBoletaRepository detalleBoletaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PastelRepository pastelRepository;

    // ================== NUEVO MÉTODO PRINCIPAL ==================

    @Transactional
    public Boleta crearDesdeDto(BoletaRequestDTO dto) {

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id " + dto.getUsuarioId()));

        Boleta boleta = new Boleta();
        boleta.setFechaEmision(
                dto.getFechaEmision() != null ? dto.getFechaEmision() : LocalDateTime.now()
        );
        boleta.setTotal(dto.getTotal());
        boleta.setUsuario(usuario);

        List<DetalleBoleta> detalles = new ArrayList<>();

        if (dto.getDetalles() != null) {
            for (DetalleBoletaRequestDTO detDto : dto.getDetalles()) {
                Pastel pastel = pastelRepository.findById(detDto.getPastelId())
                        .orElseThrow(() -> new RuntimeException("Pastel no encontrado con id " + detDto.getPastelId()));

                DetalleBoleta detalle = new DetalleBoleta();
                detalle.setBoleta(boleta);
                detalle.setPastel(pastel);
                detalle.setCantidad(detDto.getCantidad());
                detalle.setPrecioUnitario(detDto.getPrecioUnitario());
                detalle.setSubtotal(detDto.getCantidad() * detDto.getPrecioUnitario());

                detalles.add(detalle);
            }
        }

        boleta.setDetalles(detalles);

        // Gracias a CascadeType.ALL en la relación, al guardar la boleta
        // también se guardan los detalles.
        return boletaRepository.save(boleta);
    }

    // ================== MÉTODOS QUE YA TENÍAS ==================

    public List<Boleta> listarTodos() {
        return boletaRepository.findAll();
    }

    public Optional<Boleta> buscarPorId(Long id) {
        return boletaRepository.findById(id);
    }

    public List<Boleta> listarPorUsuario(Long idUsuario) {
        return boletaRepository.findByUsuario_Id(idUsuario);
    }

    public String eliminar(Long id) {
        detalleBoletaRepository.deleteByBoleta_Id(id);
        boletaRepository.deleteById(id);
        return "Boleta eliminada: " + id;
    }
}
