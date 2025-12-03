package com.pasteleria.Milsabores.Controller;

import com.pasteleria.Milsabores.Entity.Cliente;
import com.pasteleria.Milsabores.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public List<Cliente> getClientes() {
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        Optional<Cliente> c = service.obtenerPorId(id);
        return c.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cliente addCliente(@RequestBody Cliente c) {
        return service.guardar(c);
    }

    @PutMapping
    public Cliente updateCliente(@RequestBody Cliente c) {
        return service.guardar(c);
    }

    @DeleteMapping("/{id}")
    public String deleteCliente(@PathVariable Long id) {
        service.eliminar(id);
        return "Cliente eliminado con id: " + id;
    }

    

    @GetMapping("/region/{region}")
    public List<Cliente> getClientesPorRegion(@PathVariable String region) {
        return service.obtenerPorRegion(region);
    }

    @GetMapping("/comuna/{comuna}")
    public List<Cliente> getClientesPorComuna(@PathVariable String comuna) {
        return service.obtenerPorComuna(comuna);
    }
}
