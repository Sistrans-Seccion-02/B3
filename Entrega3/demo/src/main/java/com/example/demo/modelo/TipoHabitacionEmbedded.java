package com.example.demo.modelo;

import java.util.List;

public class TipoHabitacionEmbedded {
    private String nombre;
    private List<String> dotacion;
    private Integer capacidad;

    public TipoHabitacionEmbedded(){}

    public TipoHabitacionEmbedded(String nombre, List<String> dotacion , Integer capacidad){
        this.nombre=nombre;
        this.dotacion=dotacion;
        this.capacidad=capacidad;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public List<String>  getDotacion(){
        return dotacion;
    }

    public void setDotacion(List<String>  dotacion){
        this.dotacion=dotacion;
    }

    public Integer getCapacidad(){
        return capacidad;
    }

    public void setCapacidad(Integer capacidad){
        this.capacidad=capacidad;
    }
}

