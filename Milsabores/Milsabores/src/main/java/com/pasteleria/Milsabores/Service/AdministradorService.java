package com.pasteleria.Milsabores.Service;

import com.pasteleria.Milsabores.Entity.Administrador;
import com.pasteleria.Milsabores.Repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    public List<Administrador> obtenerTodos() {
        return administradorRepository.findAll();
    }

    public Optional<Administrador> obtenerPorId(Long id) {
        return administradorRepository.findById(id);
    }

    public Administrador guardar(Administrador a) {
        return administradorRepository.save(a);
    }

    public void eliminar(Long id) {
        administradorRepository.deleteById(id);
    }

    public Administrador obtenerPorCorreo(String correo) {
        return administradorRepository.findByCorreo(correo);
    }

    public List<Administrador> obtenerActivos() {
        return administradorRepository.findByActivoTrue();
    }

    public List<Administrador> obtenerPorRol(String rol) {
        return administradorRepository.findByRol(rol);
    }

    // -------- Lógica de negocio --------

    public Administrador cambiarRol(Long idAdmin, String nuevoRol) {
        Administrador a = administradorRepository.findById(idAdmin).orElse(null);
        if (a == null) return null;
        a.setRol(nuevoRol);
        return administradorRepository.save(a);
    }

    public Administrador activarAdmin(Long idAdmin) {
        Administrador a = administradorRepository.findById(idAdmin).orElse(null);
        if (a == null) return null;
        a.setActivo(true);
        return administradorRepository.save(a);
    }

    public Administrador desactivarAdmin(Long idAdmin) {
        Administrador a = administradorRepository.findById(idAdmin).orElse(null);
        if (a == null) return null;
        a.setActivo(false);
        return administradorRepository.save(a);
    }
}
