package com.example.tp_final_inmobiliaria.model;

public class Inquilino {
    private String dni;
    private String apellido;
    private String nombre;
    private Inmueble inmueble;
    private String direccionTrabajo;
    private String telefono;

    public Inquilino(String dni, String apellido, String nombre, Inmueble inmueble, String telefono) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.inmueble = inmueble;
        this.telefono = telefono;
    }

    public Inquilino(String dni, String apellido, String nombre, Inmueble inmueble, String direccionTrabajo, String telefono) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.inmueble = inmueble;
        this.direccionTrabajo = direccionTrabajo;
        this.telefono = telefono;
    }

    public String getDireccionTrabajo() {
        return direccionTrabajo;
    }

    public void setDireccionTrabajo(String direccionTrabajo) {
        this.direccionTrabajo = direccionTrabajo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
