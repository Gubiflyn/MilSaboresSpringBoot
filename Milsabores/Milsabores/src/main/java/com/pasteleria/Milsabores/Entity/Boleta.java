package com.pasteleria.Milsabores.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BOLETA")
public class Boleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_BOLETA")
    private Long id;

    @Column(name = "FECHA_EMISION", nullable = false)
    private LocalDateTime fechaEmision;

    @Column(name = "TOTAL", nullable = false)
    private Integer total;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuario usuario;

    @OneToMany(
            mappedBy = "boleta",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<DetalleBoleta> detalles = new ArrayList<>();

    public Boleta() {
    }

    // ========== Getters y Setters ==========

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<DetalleBoleta> getDetalles() {
        return detalles;
    }

    /**
     * Setea la lista completa respetando la relación bidireccional.
     */
    public void setDetalles(List<DetalleBoleta> detalles) {
        this.detalles.clear();
        if (detalles != null) {
            for (DetalleBoleta detalle : detalles) {
                addDetalle(detalle);
            }
        }
    }

    public void addDetalle(DetalleBoleta detalle) {
        if (detalle == null) return;
        detalle.setBoleta(this);
        this.detalles.add(detalle);
    }

    public void removeDetalle(DetalleBoleta detalle) {
        if (detalle == null) return;
        this.detalles.remove(detalle);
        detalle.setBoleta(null);
    }
}
