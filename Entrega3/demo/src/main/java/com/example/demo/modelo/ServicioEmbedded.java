package com.example.demo.modelo;

public class ServicioEmbedded {
    private String nombre;
    private String tipo;
    private double precio;

    public ServicioEmbedded(){}

    public ServicioEmbedded(String nombre, String tipo, double precio){
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre= nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo= tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio= precio;
    }
    
}
