package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Table(name="bares")
@Entity
public class Bar extends Servicio{

    private String nombre;
    private int capacidad;
    private String estilo;

    public Bar(String nombre, int capacidad, String estilo) {
    this.nombre = nombre;
    this.capacidad = capacidad;
    this.estilo = estilo;
}

    public Bar()
        {;}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    };
    
}
