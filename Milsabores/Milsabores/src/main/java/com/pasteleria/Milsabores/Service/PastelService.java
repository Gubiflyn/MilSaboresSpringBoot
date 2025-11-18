package com.pasteleria.Milsabores.Service;

import com.pasteleria.Milsabores.Entity.Pastel;
import com.pasteleria.Milsabores.Repository.PastelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PastelService {

    @Autowired
    private PastelRepository pastelRepository;

    public Pastel guardar(Pastel pastel) {
        return pastelRepository.save(pastel);
    }

    public List<Pastel> guardarLista(List<Pastel> pasteles) {
        return pastelRepository.saveAll(pasteles);
    }

    public List<Pastel> listarTodos() {
        return pastelRepository.findAll();
    }

    public Optional<Pastel> buscarPorId(Long id) {
        return pastelRepository.findById(id);
    }

    public Optional<Pastel> buscarPorCodigo(String codigo) {
        return pastelRepository.findByCodigo(codigo);
    }

    public List<Pastel> buscarPorNombre(String nombre) {
        return pastelRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public List<Pastel> buscarPorNombreCategoria(String nombreCategoria) {
        return pastelRepository.findByCategoria_Nombre(nombreCategoria);
    }

    public String eliminar(Long id) {
        pastelRepository.deleteById(id);
        return "Pastel eliminado: " + id;
    }

    public Pastel actualizar(Pastel pastel) {
        Pastel existente = pastelRepository
                .findById(pastel.getId())
                .orElseThrow(() -> new RuntimeException("Pastel no encontrado"));

        existente.setCodigo(pastel.getCodigo());
        existente.setNombre(pastel.getNombre());
        existente.setDescripcion(pastel.getDescripcion());
        existente.setPrecio(pastel.getPrecio());
        existente.setStock(pastel.getStock());
        existente.setImagen(pastel.getImagen());
        existente.setCategoria(pastel.getCategoria());

        return pastelRepository.save(existente);
    }
}
