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

    // ==========================
    // CRUD BÁSICO
    // ==========================

    // GET /usuarios
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    // GET por id
    public Optional<Usuario> obtenerPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    // POST crear / guardar
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // DELETE
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    // Buscar por correo (para login, etc.)
    public Usuario obtenerPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    // ==========================
    // ACTUALIZAR USUARIO DESDE DTO
    // ==========================

    public Usuario actualizarUsuario(UsuarioUpdateDTO dto) {
        if (dto.getId() == null) {
            throw new IllegalArgumentException("El id del usuario es obligatorio");
        }

        Optional<Usuario> opt = usuarioRepository.findById(dto.getId());
        if (!opt.isPresent()) {
            throw new RuntimeException("Usuario no encontrado con id: " + dto.getId());
        }

        Usuario usuario = opt.get();

        // Campos básicos
        if (dto.getNombre() != null) {
            usuario.setNombre(dto.getNombre());
        }
        if (dto.getCorreo() != null) {
            usuario.setCorreo(dto.getCorreo());
        }
        if (dto.getRol() != null) {
            usuario.setRol(dto.getRol());
        }

        // ✅ Beneficio
        if (dto.getBeneficio() != null) {
            usuario.setBeneficio(dto.getBeneficio());
        }

        // ✅ Fecha de nacimiento
        if (dto.getFechaNacimiento() != null) {
            usuario.setFechaNacimiento(dto.getFechaNacimiento());
        }

        return usuarioRepository.save(usuario);
    }
}
