package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Table(name="spas")
@Entity
public class Spa extends Servicio{
    
    private String nombre;
    private int duracion;
    private int costo;
    

    public Spa(Integer id, String tipo, Integer id_reserva, String nombre, int duracion, int costo) {
        super(id, tipo, id_reserva);
        this.nombre = nombre;
        this.duracion = duracion;
        this.costo = costo;
    }


    public Spa()
    {;}


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
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
