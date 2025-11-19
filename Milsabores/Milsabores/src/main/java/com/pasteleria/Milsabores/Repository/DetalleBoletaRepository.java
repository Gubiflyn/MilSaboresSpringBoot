package com.pasteleria.Milsabores.Repository;

import com.pasteleria.Milsabores.Entity.DetalleBoleta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetalleBoletaRepository extends JpaRepository<DetalleBoleta, Long> {

    List<DetalleBoleta> findByBoleta_Id(Long idBoleta);

    List<DetalleBoleta> findByPastel_Id(Long idPastel);
}
