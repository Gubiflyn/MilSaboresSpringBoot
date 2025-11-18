package com.pasteleria.Milsabores.Repository;

import com.pasteleria.Milsabores.Entity.Pastel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PastelRepository extends JpaRepository<Pastel, Long> {

    Optional<Pastel> findByCodigo(String codigo);

    List<Pastel> findByNombreContainingIgnoreCase(String nombre);

    List<Pastel> findByCategoria_Nombre(String nombreCategoria);
}
