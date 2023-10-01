package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(name="salon_conferencias")
@Entity
public class SalonConferencias extends Servicio{
    private int costo;
    private int capacidad;
    //clase de reserva servicio
    
    public SalonConferencias(int costo, int capacidad) {
        this.costo = costo;
        this.capacidad = capacidad;
    }

    public SalonConferencias()
    {;}



    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }


    
}
