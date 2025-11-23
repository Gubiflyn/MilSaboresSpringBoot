package com.pasteleria.Milsabores.Controller;

import com.pasteleria.Milsabores.Entity.Pastel;
import com.pasteleria.Milsabores.Service.PastelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/pasteles")
public class PastelController {

    @Autowired
    private PastelService pastelService;

    @PostMapping("/savePastel")
public ResponseEntity<?> savePastel(@RequestBody Pastel pastel) {
    try {
        System.out.println(">>> Recibido pastel en /api/pasteles/savePastel:");
        System.out.println(pastel); // usa el toString() de Pastel

        Pastel guardado = pastelService.guardar(pastel);

        System.out.println(">>> Pastel guardado correctamente con ID: " + guardado.getId());
        return ResponseEntity.ok(guardado);

    } catch (Exception e) {
        System.err.println(">>> ERROR al guardar pastel:");
        e.printStackTrace(); // AQUÍ veremos el ORA-xxxx en la consola

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al guardar pastel: " + e.getMessage());
    }
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
