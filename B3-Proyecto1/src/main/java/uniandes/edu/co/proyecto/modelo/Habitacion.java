package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Table(name="habitaciones")
@Entity
public class Habitacion {
    

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer nhabitacion;
    
    @ManyToOne
    @JoinColumn(name="tipohabitacion", referencedColumnName = "nombre")
    public TipoHabitacion tipohabitacion;


    public Habitacion(Integer nhabitacion, TipoHabitacion tipohabitacion) {
        this.nhabitacion = nhabitacion;
        this.tipohabitacion = tipohabitacion;
    }
    

    public Habitacion()
    {;}


    public Integer getnhabitacion() {
        return nhabitacion;
    }


    public void setnhabitacion(Integer nhabitacion) {
        this.nhabitacion = nhabitacion;
    }


    public TipoHabitacion gettipohabitacion() {
        return tipohabitacion;
    }


    public void settipohabitacion(TipoHabitacion tipohabitacion) {
        this.tipohabitacion = tipohabitacion;
    }

    
    
  
    

}
