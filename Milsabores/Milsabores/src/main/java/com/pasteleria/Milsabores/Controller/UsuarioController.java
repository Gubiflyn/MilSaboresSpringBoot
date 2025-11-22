package com.pasteleria.Milsabores.Controller;

import com.pasteleria.Milsabores.DTO.UsuarioUpdateDTO;
import com.pasteleria.Milsabores.Entity.Usuario;
import com.pasteleria.Milsabores.Service.UsuarioService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    // GET /usuarios
    @GetMapping("/usuarios")
    public List<Usuario> getUsuarios() {
        return service.obtenerTodos();
    }

    // GET /usuarioById/{id}
    @GetMapping("/usuarioById/{id}")
    public Optional<Usuario> getUsuarioById(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    // GET /usuarioByCorreo/{correo}
    @GetMapping("/usuarioByCorreo/{correo}")
    public Usuario getUsuarioByCorreo(@PathVariable String correo) {
        return service.obtenerPorCorreo(correo);
    }

    // POST /addUsuario
    @PostMapping("/addUsuario")
    public Usuario addUsuario(@RequestBody Usuario usuario) {
        return service.guardarUsuario(usuario);
    }

    // DELETE /deleteUsuario/{id}
    @DeleteMapping("/deleteUsuario/{id}")
    public String deleteUsuario(@PathVariable Long id) {
        service.eliminarUsuario(id);
        return "Usuario eliminado con id: " + id;
    }

    // PUT /updateUsuario → usa el DTO
    @PutMapping("/updateUsuario")
    public Usuario updateUsuario(@RequestBody UsuarioUpdateDTO dto) {
        return service.actualizarUsuario(dto);
    }
}
