package com.example.tp_final_inmobiliaria.model;

public class Usuario {
    private String nombre;
    private String apellido;
    private String rol;
    private String email;
    private String clave;

    public Usuario(String nombre, String apellido, String rol, String email, String clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
        this.email = email;
        this.clave = clave;
    }

    public Usuario(String email) {
        this.email = email;
    }

    public Usuario(String email, String clave) {
        this.email = email;
        this.clave = clave;
    }

    public Usuario() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
