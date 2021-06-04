package com.example.tp_final_inmobiliaria.model;

import java.io.Serializable;

public class Inmueble implements Serializable {
    private int idInm;
    private int idProp;
    private int foto;
    private String direccion;
    private double costo;
    private String descripcion;
    private String tipo;
    public String  uso;
    public int cantAmbientes;
    public Boolean disponible;



    public Inmueble(int idInm, int idProp, int foto, String direccion, double costo, String descripcion, String tipo, String uso, int cantAmbientes, Boolean disponible) {
        this.idInm = idInm;
        this.idProp = idProp;
        this.foto = foto;
        this.direccion = direccion;
        this.costo = costo;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.uso = uso;
        this.cantAmbientes = cantAmbientes;
        this.disponible = disponible;
    }

    public Inmueble() {
    }



    public int getId() { return idInm;}

    public void setId(int id) {
        this.idInm = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getPrecio() {
        return costo;
    }

    public void setPrecio(double precio) {
        this.costo = precio;
    }

    public int getIdProp() {
        return idProp;
    }

    public void setIdProp(int idProp) {
        this.idProp = idProp;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public int getCantAmbientes() {
        return cantAmbientes;
    }

    public void setCantAmbientes(int cantAmbientes) {
        this.cantAmbientes = cantAmbientes;
    }

    public Boolean getDisponible() { return disponible; }

    public void setDisponible(Boolean disponible) { this.disponible = disponible; }
}

