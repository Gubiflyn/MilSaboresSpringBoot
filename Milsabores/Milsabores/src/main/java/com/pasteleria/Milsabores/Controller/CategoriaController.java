package com.pasteleria.Milsabores.Controller;

import com.pasteleria.Milsabores.Entity.Categoria;
import com.pasteleria.Milsabores.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categorias")
    public List<Categoria> getCategorias() {
        return categoriaService.listarTodas();
    }

    @GetMapping("/categorias/{id}")
    public Optional<Categoria> getCategoriaById(@PathVariable Long id) {
        return categoriaService.buscarPorId(id);
    }

    @PostMapping("/categorias")
    public Categoria crearCategoria(@RequestBody Categoria categoria) {
        return categoriaService.guardar(categoria);
    }

    @PutMapping("/categorias/{id}")
    public Categoria actualizarCategoria(@PathVariable Long id,
                                         @RequestBody Categoria categoria) {
        categoria.setId(id);
        return categoriaService.guardar(categoria);
    }

    @DeleteMapping("/categorias/{id}")
    public String eliminarCategoria(@PathVariable Long id) {
        categoriaService.eliminar(id);
        return "Categoría eliminada con id: " + id;
    }
}
