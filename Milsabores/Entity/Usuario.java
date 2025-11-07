package com.pasteleria.Milsabores.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String rut;
    private String apellido;
    private String correo;
    private String contrasena;
    private String comuna;
    private String region;

    // Constructores
    public Usuario() {}

    public Usuario(String nombre, String rut, String apellido, String correo, String contrasena, String comuna, String region) {
        this.nombre = nombre;
        this.rut = rut;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.comuna = comuna;
        this.region = region;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getRut() { return rut; }
    public void setRut(String rut) { this.rut = rut; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public String getComuna() { return comuna; }
    public void setComuna(String comuna) { this.comuna = comuna; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", rut=" + rut + ", apellido=" + apellido + ", correo=" + correo + ", contrasena=" + contrasena + ", comuna=" + comuna + ", region=" + region + '}';
    }
    
    
}
