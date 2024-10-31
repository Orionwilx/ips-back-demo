package com.unimag.demo.ipsmascotas.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuarios")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private String nombre;
    private String email;
    private String contraseña;
    private String telefono;
    private String direccion;

    @Enumerated(EnumType.STRING)
    private Roltipo rol;

    @Enumerated(EnumType.STRING)
    private EstadoServicios estado;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Roltipo getRol() {
        return rol;
    }

    public void setRol(Roltipo rol) {
        this.rol = rol;
    }

    public EstadoServicios getEstado() {
        return estado;
    }

    public void setEstado(EstadoServicios estado) {
        this.estado = estado;
    }

    

}
