package com.example.demo.modelo;

import java.util.List;

import org.springframework.data.annotation.Id;

public class TipoHabitacion {

    @Id
    private String id; // Campo id para MongoDB

    private String nombre;
    private List<String> dotacion;

    // Constructor sin parámetros
    public TipoHabitacion() {}

    // Constructor con parámetros
    public TipoHabitacion(String id, String nombre, List<String> dotacion) {
        this.id = id;
        this.nombre = nombre;
        this.dotacion = dotacion;
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getDotacion() {
        return dotacion;
    }

    public void setDotacion(List<String> dotacion) {
        this.dotacion = dotacion;
    }
}
