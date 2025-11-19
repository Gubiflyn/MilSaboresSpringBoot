package com.pasteleria.Milsabores.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "DETALLE_BOLETA")
public class DetalleBoleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DETALLE")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_BOLETA", nullable = false)
    @JsonIgnore
    private Boleta boleta;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUCTO", nullable = false)
    private Pastel pastel;

    @Column(name = "CANTIDAD", nullable = false)
    private Integer cantidad;

    @Column(name = "PRECIO_UNITARIO", nullable = false)
    private Integer precioUnitario;

    @Column(name = "SUBTOTAL", nullable = false)
    private Integer subtotal;

    public DetalleBoleta() {
    }

    public DetalleBoleta(Long id, Boleta boleta, Pastel pastel,
                         Integer cantidad, Integer precioUnitario, Integer subtotal) {
        this.id = id;
        this.boleta = boleta;
        this.pastel = pastel;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Boleta getBoleta() { return boleta; }
    public void setBoleta(Boleta boleta) { this.boleta = boleta; }

    public Pastel getPastel() { return pastel; }
    public void setPastel(Pastel pastel) { this.pastel = pastel; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

    public Integer getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(Integer precioUnitario) { this.precioUnitario = precioUnitario; }

    public Integer getSubtotal() { return subtotal; }
    public void setSubtotal(Integer subtotal) { this.subtotal = subtotal; }

    @Override
    public String toString() {
        return "DetalleBoleta{" +
                "id=" + id +
                ", pastel=" + (pastel != null ? pastel.getNombre() : null) +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                ", subtotal=" + subtotal +
                '}';
    }
}
