package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Table(name="utensilios")
@Entity

public class Utensilio extends Servicio{

    private boolean devuelto;
    private String nombre;


    public Utensilio(boolean devuelto, String nombre) {
        this.devuelto = devuelto;
        this.nombre = nombre;
    }

    public Utensilio()
    {;}


    public boolean isDevuelto() {
        return devuelto;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
}
