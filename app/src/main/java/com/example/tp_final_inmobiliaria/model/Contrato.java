package com.example.tp_final_inmobiliaria.model;

import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Contrato {
    private int idCon;
    private Date fechaInicio;
    private Date fechaCierre;
    private double monto;
    private Inmueble inmueble;
    private Inquilino inquilino;

    public Contrato(Date fechaInicio, Date fechaCierre, double monto) {
        this.fechaInicio = fechaInicio;
        this.fechaCierre = fechaCierre;
        this.monto = monto;
    }

    public Contrato(Date fechaInicio, Date fechaCierre, double monto, Inmueble inmueble, Inquilino inquilino) {
        this.fechaInicio = fechaInicio;
        this.fechaCierre = fechaCierre;
        this.monto = monto;
        this.inmueble = inmueble;
        this.inquilino = inquilino;
    }

    public Contrato(int idCon, Date fechaInicio, Date fechaCierre, double monto, Inmueble inmueble, Inquilino inquilino) {
        this.idCon = idCon;
        this.fechaInicio = fechaInicio;
        this.fechaCierre = fechaCierre;
        this.monto = monto;
        this.inmueble = inmueble;
        this.inquilino = inquilino;
    }

    public Contrato() {
    }

    public Contrato(Date fechaInicio, Date fechaCierre, double monto, Inquilino inquilino) {
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

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getfechaCierre() {
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
