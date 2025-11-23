package com.pasteleria.Milsabores.DTO;

public class DetalleBoletaRequestDTO {

    private Long pastelId;
    private int cantidad;
    private int precioUnitario;

    public Long getPastelId() {
        return pastelId;
    }

    public void setPastelId(Long pastelId) {
        this.pastelId = pastelId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}
