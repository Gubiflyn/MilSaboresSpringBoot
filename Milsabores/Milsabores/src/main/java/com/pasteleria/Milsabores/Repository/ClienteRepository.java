package com.pasteleria.Milsabores.Repository;

import com.pasteleria.Milsabores.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByCorreo(String correo);

    List<Cliente> findByRegion(String region);

    List<Cliente> findByComuna(String comuna);
}
