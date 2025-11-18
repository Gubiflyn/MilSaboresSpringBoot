package com.pasteleria.Milsabores.Entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("CLIENTE")
public class Cliente extends Usuario {

    private int puntosAcumulados;
    private boolean activo;
    private LocalDate fechaRegistro;
    private String telefono;
    private String direccion;

    public Cliente() {}

    public Cliente(Long id, String nombre, String rut, String apellido,
                   String correo, String contrasena, String comuna, String region,
                   int puntosAcumulados, boolean activo, LocalDate fechaRegistro,
                   String telefono, String direccion) {
        super(id, nombre, rut, apellido, correo, contrasena, comuna, region);
        this.puntosAcumulados = puntosAcumulados;
        this.activo = activo;
        this.fechaRegistro = fechaRegistro;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public int getPuntosAcumulados() { return puntosAcumulados; }

    public void setPuntosAcumulados(int puntosAcumulados) { this.puntosAcumulados = puntosAcumulados; }

    public boolean isActivo() { return activo; }

    public void setActivo(boolean activo) { this.activo = activo; }

    public LocalDate getFechaRegistro() { return fechaRegistro; }

    public void setFechaRegistro(LocalDate fechaRegistro) { this.fechaRegistro = fechaRegistro; }

    public String getTelefono() { return telefono; }

    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDireccion() { return direccion; }

    public void setDireccion(String direccion) { this.direccion = direccion; }
}
