package com.pasteleria.Milsabores.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "VENDEDOR")
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VENDEDOR")
    private Long id;

    @Column(name = "NOMBRE", nullable = false, length = 150)
    private String nombre;

    @Column(name = "CORREO", nullable = false, unique = true, length = 150)
    private String correo;

    @Column(name ="TELEFONO", length = 20)
    private String telefono;

    @Column(name = "ESTADO", nullable = false)
    private String estado; // "activo" o "inactivo"

    public Vendedor() {}

    public Vendedor(Long id, String nombre, String correo, String telefono, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.estado = estado;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
