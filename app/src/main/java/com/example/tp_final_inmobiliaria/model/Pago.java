package com.example.tp_final_inmobiliaria.model;

public class Pago {

    private int nroPago;
    private String fecha;
    private double importe;

    public Pago(int nroPago, String fecha, double importe) {
        this.nroPago = nroPago;
        this.fecha = fecha;
        this.importe = importe;
    }

    public int getNroPago() {
        return nroPago;
    }

    public void setNroPago(int nroPago) {
        this.nroPago = nroPago;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
}
