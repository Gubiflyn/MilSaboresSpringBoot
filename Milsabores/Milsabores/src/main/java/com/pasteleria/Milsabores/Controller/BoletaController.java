package com.pasteleria.Milsabores.Controller;

import com.pasteleria.Milsabores.Entity.Boleta;
import com.pasteleria.Milsabores.Service.BoletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/boletas")
public class BoletaController {

    @Autowired
    private BoletaService boletaService;

    @PostMapping("/saveBoleta")
    public Boleta saveBoleta(@RequestBody Boleta boleta) {
        return boletaService.guardar(boleta);
    }

    @PostMapping("/saveBoletasList")
    public List<Boleta> saveBoletasList(@RequestBody List<Boleta> boletas) {
        return boletaService.guardarLista(boletas);
    }

    @GetMapping("/listBoletas")
    public List<Boleta> listBoletas() {
        return boletaService.listarTodos();
    }

    @GetMapping("/getBoletaById/{id}")
    public Boleta getBoletaById(@PathVariable Long id) {
        return boletaService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Boleta no encontrada"));
    }

    @GetMapping("/getBoletasByUsuarioId/{idUsuario}")
    public List<Boleta> getBoletasByUsuarioId(@PathVariable Long idUsuario) {
        return boletaService.buscarPorIdUsuario(idUsuario);
    }

    @PutMapping("/updateBoleta")
    public Boleta updateBoleta(@RequestBody Boleta boleta) {
        return boletaService.actualizar(boleta);
    }

    @DeleteMapping("/deleteBoletaById/{id}")
    public String deleteBoletaById(@PathVariable Long id) {
        return boletaService.eliminar(id);
    }
}
