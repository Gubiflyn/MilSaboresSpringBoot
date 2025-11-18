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

    public List<Pastel> listarTodos() {
        return pastelRepository.findAll();
    }

    public Optional<Pastel> buscarPorId(Long id) {
        return pastelRepository.findById(id);
    }

    public Optional<Pastel> buscarPorCodigo(String codigo) {
        return pastelRepository.findByCodigo(codigo);
    }

    public List<Pastel> buscarPorCategoria(String categoria) {
        return pastelRepository.findByCategoria(categoria);
    }

    public Pastel guardar(Pastel pastel) {
        return pastelRepository.save(pastel);
    }

    public void eliminar(Long id) {
        pastelRepository.deleteById(id);
    }
}
