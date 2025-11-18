package com.pasteleria.Milsabores.Controller;

import com.pasteleria.Milsabores.Entity.Administrador;
import com.pasteleria.Milsabores.Service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/administradores")
@CrossOrigin(origins = "*")
public class AdministradorController {

    @Autowired
    private AdministradorService service;

    @Value("${milsabores.admin.api-key}")
    private String adminApiKey;

    private boolean apiKeyValida(String apiKeyHeader) {
        return apiKeyHeader != null && apiKeyHeader.equals(adminApiKey);
    }

    @GetMapping
    public ResponseEntity<?> getAdministradores(
            @RequestHeader(value = "X-API-KEY", required = false) String apiKey) {

        if (!apiKeyValida(apiKey)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Acceso denegado: API Key inválida");
        }

        List<Administrador> administradores = service.obtenerTodos();
        return ResponseEntity.ok(administradores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAdministradorById(
            @PathVariable Long id,
            @RequestHeader(value = "X-API-KEY", required = false) String apiKey) {

        if (!apiKeyValida(apiKey)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Acceso denegado: API Key inválida");
        }

        Optional<Administrador> a = service.obtenerPorId(id);
        return a.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> addAdministrador(
            @RequestBody Administrador a,
            @RequestHeader(value = "X-API-KEY", required = false) String apiKey) {

        if (!apiKeyValida(apiKey)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Acceso denegado: API Key inválida");
        }

        Administrador creado = service.guardar(a);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping
    public ResponseEntity<?> updateAdministrador(
            @RequestBody Administrador a,
            @RequestHeader(value = "X-API-KEY", required = false) String apiKey) {

        if (!apiKeyValida(apiKey)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Acceso denegado: API Key inválida");
        }

        Administrador actualizado = service.guardar(a);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAdministrador(
            @PathVariable Long id,
            @RequestHeader(value = "X-API-KEY", required = false) String apiKey) {

        if (!apiKeyValida(apiKey)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Acceso denegado: API Key inválida");
        }

        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // ----------- Endpoints personalizados -----------

    @GetMapping("/activos")
    public ResponseEntity<?> getAdministradoresActivos(
            @RequestHeader(value = "X-API-KEY", required = false) String apiKey) {

        if (!apiKeyValida(apiKey)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Acceso denegado: API Key inválida");
        }

        List<Administrador> activos = service.obtenerActivos();
        return ResponseEntity.ok(activos);
    }

    @GetMapping("/rol/{rol}")
    public ResponseEntity<?> getAdministradoresPorRol(
            @PathVariable String rol,
            @RequestHeader(value = "X-API-KEY", required = false) String apiKey) {

        if (!apiKeyValida(apiKey)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Acceso denegado: API Key inválida");
        }

        List<Administrador> porRol = service.obtenerPorRol(rol);
        return ResponseEntity.ok(porRol);
    }

    @PutMapping("/{id}/rol/{nuevoRol}")
    public ResponseEntity<?> cambiarRol(
            @PathVariable Long id,
            @PathVariable String nuevoRol,
            @RequestHeader(value = "X-API-KEY", required = false) String apiKey) {

        if (!apiKeyValida(apiKey)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Acceso denegado: API Key inválida");
        }

        Administrador actualizado = service.cambiarRol(id, nuevoRol);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @PutMapping("/{id}/activar")
    public ResponseEntity<?> activarAdmin(
            @PathVariable Long id,
            @RequestHeader(value = "X-API-KEY", required = false) String apiKey) {

        if (!apiKeyValida(apiKey)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Acceso denegado: API Key inválida");
        }

        Administrador actualizado = service.activarAdmin(id);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @PutMapping("/{id}/desactivar")
    public ResponseEntity<?> desactivarAdmin(
            @PathVariable Long id,
            @RequestHeader(value = "X-API-KEY", required = false) String apiKey) {

        if (!apiKeyValida(apiKey)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Acceso denegado: API Key inválida");
        }

        Administrador actualizado = service.desactivarAdmin(id);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }
}
