package com.pasteleria.Milsabores.Repository;

import com.pasteleria.Milsabores.Entity.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

    Administrador findByCorreo(String correo);

    List<Administrador> findByActivoTrue();

    List<Administrador> findByRol(String rol);
}
