package com.pasteleria.Milsabores.Service;

import com.pasteleria.Milsabores.Entity.DetalleBoleta;
import com.pasteleria.Milsabores.Repository.DetalleBoletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleBoletaService {

    @Autowired
    private DetalleBoletaRepository detalleBoletaRepository;

    public DetalleBoleta guardar(DetalleBoleta detalle) {
        return detalleBoletaRepository.save(detalle);
    }

    public List<DetalleBoleta> guardarLista(List<DetalleBoleta> detalles) {
        return detalleBoletaRepository.saveAll(detalles);
    }

    public List<DetalleBoleta> listarTodos() {
        return detalleBoletaRepository.findAll();
    }

    public Optional<DetalleBoleta> buscarPorId(Long id) {
        return detalleBoletaRepository.findById(id);
    }

    public List<DetalleBoleta> buscarPorIdBoleta(Long idBoleta) {
        return detalleBoletaRepository.findByBoleta_Id(idBoleta);
    }

    public List<DetalleBoleta> buscarPorIdPastel(Long idPastel) {
        return detalleBoletaRepository.findByPastel_Id(idPastel);
    }

    public String eliminar(Long id) {
        detalleBoletaRepository.deleteById(id);
        return "Detalle boleta eliminado: " + id;
    }

    public DetalleBoleta actualizar(DetalleBoleta detalle) {
        DetalleBoleta existente = detalleBoletaRepository
                .findById(detalle.getId())
                .orElseThrow(() -> new RuntimeException("Detalle de boleta no encontrado"));

        existente.setBoleta(detalle.getBoleta());
        existente.setPastel(detalle.getPastel());
        existente.setCantidad(detalle.getCantidad());
        existente.setPrecioUnitario(detalle.getPrecioUnitario());
        existente.setSubtotal(detalle.getSubtotal());

        return detalleBoletaRepository.save(existente);
    }
}
