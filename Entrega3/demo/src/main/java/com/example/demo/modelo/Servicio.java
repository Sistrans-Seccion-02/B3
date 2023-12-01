package com.example.demo.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "servicios")
public class Servicio {
    @Id
    private String idservicio;

    @Field("nombre")
    private String nombre;

    @Field("tipo")
    private String tipo;

    @Field("precio")
    private double precio;

    public Servicio(){}

    public Servicio(String nombre, String tipo, double precio){

        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
    }

    public String getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(String idservicio) {
        this.idservicio = idservicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    
}
