package com.example.demo.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "habitacion")
public class Habitacion {

    @Id
    private String id;
    private int nHabitacion;
    @DBRef
    private TipoHabitacion tipoHabitacion;
    private int capacidad;

    // Constructor sin parámetros
    public Habitacion() {}

    // Constructor con parámetros
    public Habitacion(String id, int nHabitacion, TipoHabitacion tipoHabitacion, int capacidad) {
        this.id = id;
        this.nHabitacion = nHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.capacidad = capacidad;
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNHabitacion() {
        return nHabitacion;
    }

    public void setNHabitacion(int nHabitacion) {
        this.nHabitacion = nHabitacion;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
}
