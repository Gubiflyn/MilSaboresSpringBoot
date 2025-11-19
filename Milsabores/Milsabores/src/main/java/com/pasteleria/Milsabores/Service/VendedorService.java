package com.pasteleria.Milsabores.Service;

import com.pasteleria.Milsabores.Entity.Vendedor;
import com.pasteleria.Milsabores.Repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    public Vendedor guardar(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }

    public List<Vendedor> guardarLista(List<Vendedor> vendedores) {
        return vendedorRepository.saveAll(vendedores);
    }

    public List<Vendedor> listarTodos() {
        return vendedorRepository.findAll();
    }

    public Optional<Vendedor> buscarPorId(Long id) {
        return vendedorRepository.findById(id);
    }

    public Optional<Vendedor> buscarPorCorreo(String correo) {
        return vendedorRepository.findByCorreo(correo);
    }

    public String eliminar(Long id) {
        vendedorRepository.deleteById(id);
        return "Vendedor eliminado: " + id;
    }

    public Vendedor actualizar(Vendedor vendedor) {
        Vendedor existente = vendedorRepository
                .findById(vendedor.getId())
                .orElseThrow(() -> new RuntimeException("Vendedor no encontrado"));

        existente.setNombre(vendedor.getNombre());
        existente.setCorreo(vendedor.getCorreo());
        existente.setTelefono(vendedor.getTelefono());
        existente.setEstado(vendedor.getEstado());

        return vendedorRepository.save(existente);
    }
}
