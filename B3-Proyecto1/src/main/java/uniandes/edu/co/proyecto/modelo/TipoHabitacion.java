package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tiposhabitacion")
public class TipoHabitacion {
    
    // Atributos de la clase TipoHabitacion
    @Id
    private String nombre;
    private Integer dotacion;
    private int capacidad;

    // Constructor
    public TipoHabitacion(String nombre, Integer dotacion, int capacidad) {

        this.nombre = nombre;
        this.dotacion = dotacion;
        this.capacidad = capacidad;
    }
    public TipoHabitacion()
    {;}

    // Métodos getters y setters

    public String getnombre() {
        return nombre;
    }
    public Integer getDotacion() {
        return dotacion;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public void setnombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDotacion(Integer dotacion) {
        this.dotacion = dotacion;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    

}

