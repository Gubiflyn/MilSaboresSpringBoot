package com.pasteleria.Milsabores.Service;

import com.pasteleria.Milsabores.DTO.UsuarioUpdateDTO;
import com.pasteleria.Milsabores.Entity.Usuario;
import com.pasteleria.Milsabores.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // LISTAR TODOS
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    // BUSCAR POR ID
    public Optional<Usuario> obtenerPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    // CREAR / GUARDAR
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // ELIMINAR
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    // BUSCAR POR CORREO
    public Usuario obtenerPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    // 🔁 ACTUALIZAR DESDE DTO (nombre, correo, rol)
    public Usuario actualizarUsuario(UsuarioUpdateDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getId())
                .orElseThrow(() ->
                        new RuntimeException("Usuario no encontrado con id: " + dto.getId())
                );

        if (dto.getNombre() != null) {
            usuario.setNombre(dto.getNombre());
        }
        if (dto.getCorreo() != null) {
            usuario.setCorreo(dto.getCorreo());
        }
        if (dto.getRol() != null) {
            usuario.setRol(dto.getRol());
        }

        return usuarioRepository.save(usuario);
    }
}
