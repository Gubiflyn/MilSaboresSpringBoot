package com.pasteleria.Milsabores.Service;

import com.pasteleria.Milsabores.Entity.Cliente;
import com.pasteleria.Milsabores.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> obtenerTodos() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> obtenerPorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente guardar(Cliente c) {
        return clienteRepository.save(c);
    }

    public void eliminar(Long id) {
        clienteRepository.deleteById(id);
    }

    public Cliente obtenerPorCorreo(String correo) {
        return clienteRepository.findByCorreo(correo);
    }

    public List<Cliente> obtenerPorRegion(String region) {
        return clienteRepository.findByRegion(region);
    }

    public List<Cliente> obtenerPorComuna(String comuna) {
        return clienteRepository.findByComuna(comuna);
    }

    // -------- Lógica de negocio adicional (si la agregas después) --------
}
