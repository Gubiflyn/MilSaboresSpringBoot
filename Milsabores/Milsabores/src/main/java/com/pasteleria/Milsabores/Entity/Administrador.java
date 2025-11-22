package com.pasteleria.Milsabores.Entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("ADMIN")
public class Administrador extends Usuario {

    
    private boolean activo;
    private LocalDate fechaContratacion;

    public Administrador() {}

    public Administrador(Long id, String nombre, String rut, String apellido,
                         String correo, String contrasena, String comuna, String region, boolean activo, LocalDate fechaContratacion) {
        super(id, nombre, rut, apellido, correo, contrasena, comuna, region);
        this.activo = activo;
        this.fechaContratacion = fechaContratacion;
    }



    public boolean isActivo() { return activo; }

    public void setActivo(boolean activo) { this.activo = activo; }

    public LocalDate getFechaContratacion() { return fechaContratacion; }

    public void setFechaContratacion(LocalDate fechaContratacion) { this.fechaContratacion = fechaContratacion; }
}
