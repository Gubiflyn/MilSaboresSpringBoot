package com.pasteleria.Milsabores.Controller;

import com.pasteleria.Milsabores.DTO.BoletaDTO;
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
    public BoletaDTO saveBoleta(@RequestBody BoletaRequestDTO request) {
        // Recibimos un DTO con usuarioId, total y detalles
        Boleta boletaCreada = boletaService.crearDesdeDto(request);
        // Devolvemos un DTO enriquecido (con usuario y detalles)
        return boletaService.mapearABoletaDto(boletaCreada);
    }

    @GetMapping("/listBoletas")
    public List<BoletaDTO> getBoletas() {
        return boletaService.listarTodosDto();
    }

    @GetMapping("/getBoletasByUsuarioId/{idUsuario}")
    public List<BoletaDTO> getBoletasByUsuarioId(@PathVariable Long idUsuario) {
        return boletaService.listarPorUsuarioDto(idUsuario);
    }

    @DeleteMapping("/deleteBoletaById/{id}")
    public String deleteBoletaById(@PathVariable Long id) {
        return boletaService.eliminar(id);
    }
}
