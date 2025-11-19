package com.pasteleria.Milsabores.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
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

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "boleta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleBoleta> detalles;

    public Boleta() {
    }

    public Boleta(Long id, LocalDateTime fechaEmision, Integer total,
                  Usuario usuario, List<DetalleBoleta> detalles) {
        this.id = id;
        this.fechaEmision = fechaEmision;
        this.total = total;
        this.usuario = usuario;
        this.detalles = detalles;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getFechaEmision() { return fechaEmision; }
    public void setFechaEmision(LocalDateTime fechaEmision) { this.fechaEmision = fechaEmision; }

    public Integer getTotal() { return total; }
    public void setTotal(Integer total) { this.total = total; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public List<DetalleBoleta> getDetalles() { return detalles; }
    public void setDetalles(List<DetalleBoleta> detalles) { this.detalles = detalles; }

    @Override
    public String toString() {
        return "Boleta{" +
                "id=" + id +
                ", fechaEmision=" + fechaEmision +
                ", total=" + total +
                ", usuario=" + (usuario != null ? usuario.getCorreo() : null) +
                '}';
    }
}
