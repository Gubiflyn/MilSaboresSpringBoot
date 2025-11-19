package com.pasteleria.Milsabores.Controller;

import com.pasteleria.Milsabores.Service.UsuarioService;
import com.pasteleria.Milsabores.Entity.Usuario;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Milsabores
 */

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/addUsuario")
    public Usuario addUsuario(@RequestBody Usuario u) {
        return service.guardarUsuario(u);
    }

    @GetMapping("/usuarios")
    public List<Usuario> findAllUsuarios() {
        return service.listarUsuarios();
    }

    @GetMapping("/usuarioById/{id}")
    public Optional<Usuario> findUsuarioById(@PathVariable Long id) {
        return service.obtenerUsuarioPorId(id);
    }

    @GetMapping("/usuarioByCorreo/{correo}")
    public Usuario findUsuarioByCorreo(@PathVariable String correo) {
        return service.obtenerPorCorreo(correo);
    }

    @DeleteMapping("/deleteUsuario/{id}")
    public String deleteUsuario(@PathVariable Long id) {
        service.eliminarUsuario(id);
        return "Usuario eliminado con id: " + id;
    }

    @PutMapping("/updateUsuario")
    public Usuario updateUsuario(@RequestBody Usuario u) {
        return service.guardarUsuario(u);
    }
}
