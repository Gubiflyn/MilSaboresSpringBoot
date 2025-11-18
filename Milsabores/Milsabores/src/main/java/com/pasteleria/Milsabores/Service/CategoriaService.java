package com.pasteleria.Milsabores.Service;

import com.pasteleria.Milsabores.Entity.Categoria;
import com.pasteleria.Milsabores.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria guardar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> guardarLista(List<Categoria> categorias) {
        return categoriaRepository.saveAll(categorias);
    }

    public List<Categoria> listarTodas() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> buscarPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    public Optional<Categoria> buscarPorNombre(String nombre) {
        return categoriaRepository.findByNombre(nombre);
    }

    public String eliminar(Long id) {
        categoriaRepository.deleteById(id);
        return "Categoría eliminada: " + id;
    }

    public Categoria actualizar(Categoria categoria) {
        Categoria existente = categoriaRepository
                .findById(categoria.getId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        existente.setNombre(categoria.getNombre());
        existente.setDescripcion(categoria.getDescripcion());

        return categoriaRepository.save(existente);
    }
}
