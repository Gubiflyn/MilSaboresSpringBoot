package com.pasteleria.Milsabores.Controller;

import com.pasteleria.Milsabores.Entity.Pastel;
import com.pasteleria.Milsabores.Service.PastelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/pasteles")
public class PastelController {

    @Autowired
    private PastelService pastelService;

    @PostMapping("/savePastel")
    public Pastel savePastel(@RequestBody Pastel pastel) {
        return pastelService.guardar(pastel);
    }

    @PostMapping("/savePastelesList")
    public List<Pastel> savePastelesList(@RequestBody List<Pastel> pasteles) {
        return pastelService.guardarLista(pasteles);
    }

    @GetMapping("/listPasteles")
    public List<Pastel> listPasteles() {
        return pastelService.listarTodos();
    }

    @GetMapping("/getPastelById/{id}")
    public Pastel getPastelById(@PathVariable Long id) {
        return pastelService.buscarPorId(id).orElse(null);
    }

    @GetMapping("/getPastelByCodigo/{codigo}")
    public Pastel getPastelByCodigo(@PathVariable String codigo) {
        return pastelService.buscarPorCodigo(codigo).orElse(null);
    }

    @GetMapping("/getPastelesByNombre/{nombre}")
    public List<Pastel> getPastelesByNombre(@PathVariable String nombre) {
        return pastelService.buscarPorNombre(nombre);
    }

    @GetMapping("/getPastelesByCategoria/{nombreCategoria}")
    public List<Pastel> getPastelesByCategoria(@PathVariable String nombreCategoria) {
        return pastelService.buscarPorNombreCategoria(nombreCategoria);
    }

    @PutMapping("/updatePastel")
    public Pastel updatePastel(@RequestBody Pastel pastel) {
        return pastelService.actualizar(pastel);
    }

    @DeleteMapping("/deletePastelById/{id}")
    public String deletePastelById(@PathVariable Long id) {
        return pastelService.eliminar(id);
    }
}
