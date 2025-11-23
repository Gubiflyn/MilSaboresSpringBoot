package com.pasteleria.Milsabores.Service;

import com.pasteleria.Milsabores.Entity.Boleta;
import com.pasteleria.Milsabores.Entity.DetalleBoleta;
import com.pasteleria.Milsabores.Repository.BoletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoletaService {

    @Autowired
    private BoletaRepository boletaRepository;

    public Boleta guardar(Boleta boleta) {
        if (boleta.getDetalles() != null) {
            for (DetalleBoleta detalle : boleta.getDetalles()) {
                detalle.setBoleta(boleta);
            }
        }
        return boletaRepository.save(boleta);
    }

    public List<Boleta> guardarLista(List<Boleta> boletas) {
        for (Boleta boleta : boletas) {
            if (boleta.getDetalles() != null) {
                for (DetalleBoleta detalle : boleta.getDetalles()) {
                    detalle.setBoleta(boleta);
                }
            }
        }
        return boletaRepository.saveAll(boletas);
    }

    public List<Boleta> listarTodas() {
        return boletaRepository.findAll();
    }

    public Optional<Boleta> buscarPorId(Long id) {
        return boletaRepository.findById(id);
    }

    public List<Boleta> listarPorUsuario(Long idUsuario) {
        return boletaRepository.findByUsuario_Id(idUsuario);
    }

    public String eliminar(Long id) {
        boletaRepository.deleteById(id);
        return "Boleta eliminada: " + id;
    }

    public Boleta actualizar(Boleta boleta) {
        Boleta existente = boletaRepository
                .findById(boleta.getId())
                .orElseThrow(() -> new RuntimeException("Boleta no encontrada"));

        existente.setFechaEmision(boleta.getFechaEmision());
        existente.setTotal(boleta.getTotal());
        existente.setUsuario(boleta.getUsuario());
        existente.setDetalles(boleta.getDetalles());

        if (existente.getDetalles() != null) {
            for (DetalleBoleta detalle : existente.getDetalles()) {
                detalle.setBoleta(existente);
            }
        }

        return boletaRepository.save(existente);
    }
}
