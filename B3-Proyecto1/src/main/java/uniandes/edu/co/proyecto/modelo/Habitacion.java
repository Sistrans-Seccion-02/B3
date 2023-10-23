package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;


@Table(name="habitaciones")
@Entity
public class Habitacion {
    
    
    @Id
    private Integer numHabitacion;


    @JoinColumn(name="tipo", referencedColumnName = "nombre")
        private String tipo;



    public Habitacion(Integer numHabitacion, String tipo) {
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


    public String getTipo() {
        return tipo;
    }


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    
  
    

}
