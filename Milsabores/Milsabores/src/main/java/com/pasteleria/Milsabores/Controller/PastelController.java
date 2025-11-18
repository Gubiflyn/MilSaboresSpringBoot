package com.pasteleria.Milsabores.Controller;

import com.pasteleria.Milsabores.Entity.Pastel;
import com.pasteleria.Milsabores.Service.PastelService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class PastelController {

    @Autowired
    private PastelService pastelService;

    @GetMapping("/pasteles")
    public List<Pastel> getPasteles() {
        return pastelService.listarTodos();
    }

    @GetMapping("/pasteles/{id}")
    public Optional<Pastel> getPastelById(@PathVariable Long id) {
        return pastelService.buscarPorId(id);
    }

    @GetMapping("/pasteles/codigo/{codigo}")
    public Optional<Pastel> getPastelByCodigo(@PathVariable String codigo) {
        return pastelService.buscarPorCodigo(codigo);
    }

    @GetMapping("/pasteles/categoria/{categoria}")
    public List<Pastel> getPastelesByCategoria(@PathVariable String categoria) {
        return pastelService.buscarPorCategoria(categoria);
    }

    @PostMapping("/pasteles")
    public Pastel crearPastel(@RequestBody Pastel pastel) {
        return pastelService.guardar(pastel);
    }

    @PutMapping("/pasteles/{id}")
    public Pastel actualizarPastel(@PathVariable Long id, @RequestBody Pastel pastel) {
        pastel.setId(id);
        return pastelService.guardar(pastel);
    }

    @DeleteMapping("/pasteles/{id}")
    public String eliminarPastel(@PathVariable Long id) {
        pastelService.eliminar(id);
        return "Pastel eliminado con id: " + id;
    }
}
