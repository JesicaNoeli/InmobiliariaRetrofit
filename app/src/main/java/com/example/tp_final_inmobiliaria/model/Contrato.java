package com.example.tp_final_inmobiliaria.model;

public class Contrato {
    private int idCon;
    private String fechaInicio;
    private String fechaCierre;
    private double monto;
    private Inmueble inmueble;
    private Inquilino inquilino;

    public Contrato(String fechaInicio, String fechaCierre, double monto) {
        this.fechaInicio = fechaInicio;
        this.fechaCierre = fechaCierre;
        this.monto = monto;
    }

    public Contrato(String fechaInicio, String fechaCierre, double monto, Inmueble inmueble, Inquilino inquilino) {
        this.fechaInicio = fechaInicio;
        this.fechaCierre = fechaCierre;
        this.monto = monto;
        this.inmueble = inmueble;
        this.inquilino = inquilino;
    }

    public Contrato(int idCon, String fechaInicio, String fechaCierre, double monto, Inmueble inmueble, Inquilino inquilino) {
        this.idCon = idCon;
        this.fechaInicio = fechaInicio;
        this.fechaCierre = fechaCierre;
        this.monto = monto;
        this.inmueble = inmueble;
        this.inquilino = inquilino;
    }

    public Contrato() {
    }

    public Contrato(String fechaInicio, String fechaCierre, double monto, Inquilino inquilino) {
        this.fechaInicio = fechaInicio;
        this.fechaCierre = fechaCierre;
        this.monto = monto;
        this.inquilino = inquilino;
    }

    public int getIdCon() {
        return idCon;
    }

    public void setIdCon(int idCon) {
        this.idCon = idCon;
    }

    public String getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(String fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public Inmueble getInmo() {
        return inmueble;
    }

    public void setInmo(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getfechaCierre() {
        return fechaCierre;
    }

    public void setFechaFinalizacion(String fechaFinalizacion) {
        this.fechaCierre = fechaCierre;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
