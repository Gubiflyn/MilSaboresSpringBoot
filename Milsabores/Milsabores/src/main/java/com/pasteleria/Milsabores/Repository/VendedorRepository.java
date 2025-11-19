package com.pasteleria.Milsabores.Repository;

import com.pasteleria.Milsabores.Entity.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

    Optional<Vendedor> findByCorreo(String correo);
}
