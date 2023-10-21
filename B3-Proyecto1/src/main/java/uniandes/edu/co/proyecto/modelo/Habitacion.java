package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;


@Entity
@Table(name="habitaciones")
public class Habitacion {
    
    
    @Id
    private Integer numHabitacion;


    @JoinColumn(name="tipo", referencedColumnName = "nombre")
    private TipoHabitacion tipo;


    public Habitacion(Integer numHabitacion, TipoHabitacion tipo) {
        this.numHabitacion = numHabitacion;
        this.tipo = tipo;
    }
    

    public Habitacion()
    {;}


    public Integer getNumHabitacion() {
        return numHabitacion;
    }


    public void setNumHabitacion(Integer numHabitacion) {
        this.numHabitacion = numHabitacion;
    }


    public TipoHabitacion getTipo() {
        return tipo;
    }


    public void setTipo(TipoHabitacion tipo) {
        this.tipo = tipo;
    }

    
    
  
    

}
