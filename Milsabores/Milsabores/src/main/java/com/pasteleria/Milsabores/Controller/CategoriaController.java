package com.pasteleria.Milsabores.Controller;

import com.pasteleria.Milsabores.Entity.Categoria;
import com.pasteleria.Milsabores.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("/saveCategoria")
    public Categoria saveCategoria(@RequestBody Categoria categoria) {
        return categoriaService.guardar(categoria);
    }

    @PostMapping("/saveCategoriasList")
    public List<Categoria> saveCategoriasList(@RequestBody List<Categoria> categorias) {
        return categoriaService.guardarLista(categorias);
    }

    @GetMapping("/listCategorias")
    public List<Categoria> listCategorias() {
        return categoriaService.listarTodas();
    }

    @GetMapping("/getCategoriaById/{id}")
    public Categoria getCategoriaById(@PathVariable Long id) {
        return categoriaService.buscarPorId(id).orElse(null);
    }

    @GetMapping("/getCategoriaByNombre/{nombre}")
    public Categoria getCategoriaByNombre(@PathVariable String nombre) {
        return categoriaService.buscarPorNombre(nombre).orElse(null);
    }

    @PutMapping("/updateCategoria")
    public Categoria updateCategoria(@RequestBody Categoria categoria) {
        return categoriaService.actualizar(categoria);
    }

    @DeleteMapping("/deleteCategoriaById/{id}")
    public String deleteCategoriaById(@PathVariable Long id) {
        return categoriaService.eliminar(id);
    }
}
