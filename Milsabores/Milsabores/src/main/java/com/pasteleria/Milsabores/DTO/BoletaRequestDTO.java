package com.pasteleria.Milsabores.DTO;

import java.time.LocalDateTime;
import java.util.List;

public class BoletaRequestDTO {

    private LocalDateTime fechaEmision;
    private Long usuarioId;
    private int total;
    private List<DetalleBoletaRequestDTO> detalles;

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<DetalleBoletaRequestDTO> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleBoletaRequestDTO> detalles) {
        this.detalles = detalles;
    }
}
