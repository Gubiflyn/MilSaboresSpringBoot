package com.pasteleria.Milsabores.Repository;

import com.pasteleria.Milsabores.Entity.Boleta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoletaRepository extends JpaRepository<Boleta, Long> {

    List<Boleta> findByUsuario_Id(Long idUsuario);
}
