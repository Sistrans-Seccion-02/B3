package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Table(name="bares")
@Entity
public class Bar extends Servicio{

    private int capacidad;
    private String estilo;
    
    public Bar(int id, int capacidad, String estilo) {
        this.capacidad = capacidad;
        this.estilo = estilo;
    }

    public Bar()
    {;}


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
    }

    
    
}
