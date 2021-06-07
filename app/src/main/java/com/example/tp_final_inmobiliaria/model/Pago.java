package com.example.tp_final_inmobiliaria.model;

import java.util.Date;

public class Pago {

    private int idPago;
    private int numPago;
    private Date fechaPago;
    private double importe;
    private Contrato contrato;



    public Pago(int numPago, Date fechaPago, double importe) {
        this.numPago = numPago;
        this.fechaPago = fechaPago;
        this.importe = importe;
    }

    public Pago(int numPago, Date fechaPago, double importe, Contrato contrato) {
        this.numPago = numPago;
        this.fechaPago = fechaPago;
        this.importe = importe;
        this.contrato = contrato;
    }

    public Pago(int numPago, Date fechaPago, double importe, Contrato contrato,int idPago) {
        this.idPago = idPago;
        this.numPago = numPago;
        this.fechaPago = fechaPago;
        this.importe = importe;
        this.contrato = contrato;
    }

    public Pago(int idPago, int numPago, Date fechaPago, double importe) {
        this.idPago = idPago;
        this.numPago = numPago;
        this.fechaPago = fechaPago;
        this.importe = importe;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public int getNumPago() {
        return numPago;
    }

    public void setNumPago(int numPago) {
        this.numPago = numPago;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
}
