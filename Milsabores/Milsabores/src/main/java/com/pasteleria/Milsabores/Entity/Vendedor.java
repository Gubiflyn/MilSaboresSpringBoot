package com.pasteleria.Milsabores.Entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("VENDEDOR")
public class Vendedor extends Usuario {

    // Campos específicos del vendedor, usando columnas que YA existen en USUARIOS
    private String telefono;          // columna TELEFONO
    private boolean activo;           // columna ACTIVO
    private LocalDate fechaContratacion; // columna FECHA_CONTRATACION

    public Vendedor() {}

    // GETTERS / SETTERS

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }
}
