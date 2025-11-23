package com.pasteleria.Milsabores.Controller;

import com.pasteleria.Milsabores.DTO.BoletaRequestDTO;
import com.pasteleria.Milsabores.Entity.Boleta;
import com.pasteleria.Milsabores.Service.BoletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boletas")
@CrossOrigin(origins = "http://localhost:5173")
public class BoletaController {

    @Autowired
    private BoletaService boletaService;

    @PostMapping("/saveBoleta")
    public Boleta saveBoleta(@RequestBody BoletaRequestDTO request) {
        // Aquí ya NO recibimos una Boleta con un Usuario adentro,
        // sino un DTO con usuarioId y detalles.
        return boletaService.crearDesdeDto(request);
    }

    @GetMapping("/listBoletas")
    public List<Boleta> getBoletas() {
        return boletaService.listarTodos();
    }

    @GetMapping("/getBoletasByUsuarioId/{idUsuario}")
    public List<Boleta> getBoletasByUsuarioId(@PathVariable Long idUsuario) {
        return boletaService.listarPorUsuario(idUsuario);
    }

    @DeleteMapping("/deleteBoletaById/{id}")
    public String deleteBoletaById(@PathVariable Long id) {
        return boletaService.eliminar(id);
    }
}
