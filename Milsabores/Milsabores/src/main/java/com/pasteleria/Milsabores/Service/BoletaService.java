package com.pasteleria.Milsabores.Service;

import com.pasteleria.Milsabores.DTO.BoletaDTO;
import com.pasteleria.Milsabores.DTO.BoletaRequestDTO;
import com.pasteleria.Milsabores.DTO.DetalleBoletaDTO;
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
import java.util.stream.Collectors;

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

  

    @Transactional
    public Boleta crearDesdeDto(BoletaRequestDTO dto) {

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() ->
                        new RuntimeException("Usuario no encontrado con id " + dto.getUsuarioId())
                );

        Boleta boleta = new Boleta();
        boleta.setFechaEmision(
                dto.getFechaEmision() != null ? dto.getFechaEmision() : LocalDateTime.now()
        );
        boleta.setTotal(dto.getTotal());
        boleta.setUsuario(usuario);

       
        boleta.setNombreUsuario(usuario.getNombre());
        boleta.setRutUsuario(usuario.getRut());

        List<DetalleBoleta> detalles = new ArrayList<>();

        if (dto.getDetalles() != null) {
            dto.getDetalles().forEach(detDto -> {
              
                Pastel pastel = pastelRepository.findById(detDto.getPastelId())
                        .orElseThrow(() ->
                                new RuntimeException("Pastel no encontrado con id " + detDto.getPastelId())
                        );

                DetalleBoleta detalle = new DetalleBoleta();
                detalle.setBoleta(boleta);
                detalle.setPastel(pastel);
                detalle.setCantidad(detDto.getCantidad());
                detalle.setPrecioUnitario(detDto.getPrecioUnitario());
                detalle.setSubtotal(detDto.getCantidad() * detDto.getPrecioUnitario());

               
                detalle.setCodigoProducto(pastel.getCodigo());
                detalle.setNombreProducto(pastel.getNombre());

                detalles.add(detalle);
            });
        }

        boleta.setDetalles(detalles);

       
        return boletaRepository.save(boleta);
    }

  

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



    @Transactional(readOnly = true)
    public List<BoletaDTO> listarTodosDto() {
        List<Boleta> boletas = boletaRepository.findAll();
        return boletas.stream()
                .map(this::mapearABoletaDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<BoletaDTO> listarPorUsuarioDto(Long idUsuario) {
        List<Boleta> boletas = boletaRepository.findByUsuario_Id(idUsuario);
        return boletas.stream()
                .map(this::mapearABoletaDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public BoletaDTO mapearABoletaDto(Boleta boleta) {
        if (boleta == null) return null;

        BoletaDTO dto = new BoletaDTO();
        dto.setId(boleta.getId());
        dto.setFechaEmision(boleta.getFechaEmision());
        dto.setTotal(boleta.getTotal());
        dto.setNombreUsuario(boleta.getNombreUsuario());
        dto.setRutUsuario(boleta.getRutUsuario());

        Usuario usuario = boleta.getUsuario();
        if (usuario != null) {
            dto.setUsuarioId(usuario.getId());
            dto.setCorreoUsuario(usuario.getCorreo());
        }

        List<DetalleBoletaDTO> detallesDto = new ArrayList<>();
        if (boleta.getDetalles() != null) {
            for (DetalleBoleta det : boleta.getDetalles()) {
                detallesDto.add(mapearADetalleDto(det));
            }
        }
        dto.setDetalles(detallesDto);

        return dto;
    }

    private DetalleBoletaDTO mapearADetalleDto(DetalleBoleta detalle) {
        if (detalle == null) return null;

        DetalleBoletaDTO dto = new DetalleBoletaDTO();
        dto.setId(detalle.getId());
        dto.setCantidad(detalle.getCantidad());
        dto.setPrecioUnitario(detalle.getPrecioUnitario());
        dto.setSubtotal(detalle.getSubtotal());

        Pastel pastel = detalle.getPastel();
        if (pastel != null) {
            dto.setCodigoProducto(pastel.getCodigo());
            dto.setNombreProducto(pastel.getNombre());
        } else {
            dto.setCodigoProducto(detalle.getCodigoProducto());
            dto.setNombreProducto(detalle.getNombreProducto());
        }

        return dto;
    }
}
