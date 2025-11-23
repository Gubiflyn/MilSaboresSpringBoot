package com.pasteleria.Milsabores.Service;

import com.pasteleria.Milsabores.Entity.Pastel;
import com.pasteleria.Milsabores.Repository.PastelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PastelService {

    @Autowired
    private PastelRepository pastelRepository;

    // ===============================
    // GUARDAR (CREAR)
    // ===============================
    public Pastel guardar(Pastel pastel) {

    // Si por algún motivo llegara id = 0, lo tratamos como nuevo
    if (pastel.getId() != null && pastel.getId() == 0) {
        pastel.setId(null);
    }

    if (pastel.getCodigo() == null || pastel.getCodigo().trim().isEmpty()) {
        pastel.setCodigo(generarCodigo(pastel));
    }

    return pastelRepository.save(pastel);
}


    // Método para generar código único
    private String generarCodigo(Pastel pastel) {

        // Base del código (PROD si no hay nombre)
        String base = (pastel.getNombre() != null && !pastel.getNombre().isBlank())
                ? pastel.getNombre().replaceAll("\\s+", "").toUpperCase()
                : "PROD";

        // Máximo 10 caracteres para no pasar el límite de la columna
        if (base.length() > 10) {
            base = base.substring(0, 10);
        }

        // Sufijo numérico único basado en timestamp
        String sufijo = String.valueOf(System.currentTimeMillis());
        sufijo = sufijo.substring(sufijo.length() - 6); // últimos 6 dígitos

        return base + sufijo; // Ejemplo: TORTAJAMON123456
    }

    // ===============================
    // GUARDAR LISTA
    // ===============================
    public List<Pastel> guardarLista(List<Pastel> pasteles) {
        return pastelRepository.saveAll(pasteles);
    }

    // ===============================
    // LISTAR
    // ===============================
    public List<Pastel> listarTodos() {
        return pastelRepository.findAll();
    }

    public Optional<Pastel> buscarPorId(Long id) {
        return pastelRepository.findById(id);
    }

    public Optional<Pastel> buscarPorCodigo(String codigo) {
        return pastelRepository.findByCodigo(codigo);
    }

    public List<Pastel> buscarPorNombre(String nombre) {
        return pastelRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public List<Pastel> buscarPorNombreCategoria(String nombreCategoria) {
        return pastelRepository.findByCategoria_Nombre(nombreCategoria);
    }

    // ===============================
    // ELIMINAR
    // ===============================
    public String eliminar(Long id) {
        pastelRepository.deleteById(id);
        return "Pastel eliminado: " + id;
    }

    // ===============================
    // ACTUALIZAR
    // ===============================
    public Pastel actualizar(Pastel pastel) {

        Pastel existente = pastelRepository
                .findById(pastel.getId())
                .orElseThrow(() -> new RuntimeException("Pastel no encontrado"));

        // Si el usuario borra el código, volvemos a generar uno
        if (pastel.getCodigo() == null || pastel.getCodigo().trim().isEmpty()) {
            existente.setCodigo(generarCodigo(pastel));
        } else {
            existente.setCodigo(pastel.getCodigo());
        }

        existente.setNombre(pastel.getNombre());
        existente.setDescripcion(pastel.getDescripcion());
        existente.setPrecio(pastel.getPrecio());
        existente.setStock(pastel.getStock());
        existente.setImagen(pastel.getImagen());
        existente.setCategoria(pastel.getCategoria());

        return pastelRepository.save(existente);
    }
}
