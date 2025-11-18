package com.pasteleria.Milsabores.Repository;

import com.pasteleria.Milsabores.Entity.Pastel;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PastelRepository extends JpaRepository<Pastel, Long> {

    Optional<Pastel> findByCodigo(String codigo);

    List<Pastel> findByCategoria(String categoria);
}
