package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Table(name="spa")
@Entity

public class Spa extends Servicio{
    private int duracion;
    private int costo;
    
    public Spa(int duracion, int costo) {
        this.duracion = duracion;
        this.costo = costo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    } 

    
    
}
