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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_BOLETA", nullable = false)
    private Boleta boleta;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PRODUCTO", nullable = false)
    private Pastel pastel;

  
    @Column(name = "CODIGO_PRODUCTO", length = 20)
    private String codigoProducto;

    @Column(name = "NOMBRE_PRODUCTO", length = 200)
    private String nombreProducto;

    @Column(name = "CANTIDAD", nullable = false)
    private Integer cantidad;

    @Column(name = "PRECIO_UNITARIO", nullable = false)
    private Integer precioUnitario;

    @Column(name = "SUBTOTAL", nullable = false)
    private Integer subtotal;

    public DetalleBoleta() {
    }

  

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boleta getBoleta() {
        return boleta;
    }

    public void setBoleta(Boleta boleta) {
        this.boleta = boleta;
    }

    public Pastel getPastel() {
        return pastel;
    }

    public void setPastel(Pastel pastel) {
        this.pastel = pastel;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Integer precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Integer getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Integer subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "DetalleBoleta{" +
                "id=" + id +
                ", pastel=" + (pastel != null ? pastel.getNombre() : null) +
                ", codigoProducto='" + codigoProducto + '\'' +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                ", subtotal=" + subtotal +
                '}';
    }
}
