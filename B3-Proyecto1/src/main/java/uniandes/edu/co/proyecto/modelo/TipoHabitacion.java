package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="tipo_habitacion")
public class TipoHabitacion {
    
    // Atributos de la clase TipoHabitacion
    private int id;
    private String nombre;
    private String dotacion;
    private int capacidad;

    // Constructor
    public TipoHabitacion(int id, String nombre, String dotacion, int capacidad) {
        this.id = id;
        this.nombre = nombre;
        this.dotacion = dotacion;
        this.capacidad = capacidad;
    }
    public TipoHabitacion()
    {;}

    // Métodos getters y setters
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDotacion() {
        return dotacion;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDotacion(String dotacion) {
        this.dotacion = dotacion;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    

}

