package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Table(name="internets")
@Entity
public class Internet extends Servicio{
    private int capacidad;

    public Internet(int capacidad){
        this.capacidad = capacidad;
    }

    public Internet()
    {;}

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    
}


