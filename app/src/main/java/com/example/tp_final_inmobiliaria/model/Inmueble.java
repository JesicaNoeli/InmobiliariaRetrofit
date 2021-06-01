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
    public int CantAmbientes;
    public Boolean Disponible;

    public Inmueble(int id, int foto, String direccion, double precio, String descripcion, String tipo) {
        this.idInm = id;
        this.foto = foto;
        this.direccion = direccion;
        this.costo = precio;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public Inmueble(int idInm, int idProp, int foto, String direccion, double costo, String descripcion, String tipo, String uso, int cantAmbientes, Boolean disponible) {
        this.idInm = idInm;
        this.idProp = idProp;
        this.foto = foto;
        this.direccion = direccion;
        this.costo = costo;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.uso = uso;
        CantAmbientes = cantAmbientes;
        Disponible = disponible;
    }

    public Inmueble() {
    }

    public Inmueble(int id, String direccion, double precio, String tipo) {
        this.idInm = id;
        this.direccion = direccion;
        this.costo = precio;
        this.tipo = tipo;
    }

    public Inmueble(int foto, String direccion, double precio, String descripcion, String tipo) {
        this.foto = foto;
        this.direccion = direccion;
        this.costo = precio;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public int getId() {
        return idInm;
    }

    public void setId(int id) {
        idInm = id;
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

    public int getIdInm() {
        return idInm;
    }

    public void setIdInm(int idInm) {
        this.idInm = idInm;
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
        return CantAmbientes;
    }

    public void setCantAmbientes(int cantAmbientes) {
        CantAmbientes = cantAmbientes;
    }

    public Boolean getDisponible() {
        return Disponible;
    }

    public void setDisponible(Boolean disponible) {
        Disponible = disponible;
    }
}

