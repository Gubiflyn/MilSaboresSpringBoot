package com.pasteleria.Milsabores.DTO;

import java.time.LocalDateTime;
import java.util.List;

public class BoletaDTO {

    private Long id;
    private LocalDateTime fechaEmision;
    private Integer total;

 
    private Long usuarioId;
    private String nombreUsuario;
    private String rutUsuario;
    private String correoUsuario;

    
    private List<DetalleBoletaDTO> detalles;

    public BoletaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getRutUsuario() {
        return rutUsuario;
    }

    public void setRutUsuario(String rutUsuario) {
        this.rutUsuario = rutUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public List<DetalleBoletaDTO> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleBoletaDTO> detalles) {
        this.detalles = detalles;
    }
}
