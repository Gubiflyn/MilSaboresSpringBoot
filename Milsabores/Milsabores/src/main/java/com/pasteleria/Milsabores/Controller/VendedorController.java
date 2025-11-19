package com.pasteleria.Milsabores.Controller;

import com.pasteleria.Milsabores.Entity.Vendedor;
import com.pasteleria.Milsabores.Service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/vendedores")
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;

    @PostMapping("/saveVendedor")
    public Vendedor saveVendedor(@RequestBody Vendedor vendedor) {
        return vendedorService.guardar(vendedor);
    }

    @PostMapping("/saveVendedoresList")
    public List<Vendedor> saveVendedoresList(@RequestBody List<Vendedor> vendedores) {
        return vendedorService.guardarLista(vendedores);
    }

    @GetMapping("/listVendedores")
    public List<Vendedor> listVendedores() {
        return vendedorService.listarTodos();
    }

    @GetMapping("/getVendedorById/{id}")
    public Vendedor getVendedorById(@PathVariable Long id) {
        return vendedorService.buscarPorId(id).orElse(null);
    }

    @GetMapping("/getVendedorByCorreo/{correo}")
    public Vendedor getVendedorByCorreo(@PathVariable String correo) {
        return vendedorService.buscarPorCorreo(correo).orElse(null);
    }

    @PutMapping("/updateVendedor")
    public Vendedor updateVendedor(@RequestBody Vendedor vendedor) {
        return vendedorService.actualizar(vendedor);
    }

    @DeleteMapping("/deleteVendedorById/{id}")
    public String deleteVendedorById(@PathVariable Long id) {
        return vendedorService.eliminar(id);
    }
}
