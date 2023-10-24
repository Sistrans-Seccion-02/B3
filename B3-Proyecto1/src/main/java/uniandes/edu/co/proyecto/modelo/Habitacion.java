package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Table(name="habitaciones")
@Entity
public class Habitacion {
    

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="nhabitacion")
    private Integer nHabitacion;
    
    @ManyToOne
    @JoinColumn(name="tipohabitacion", referencedColumnName = "nombre")
    private TipoHabitacion tipo;


    public Habitacion(Integer nHabitacion, TipoHabitacion tipo) {
        this.nHabitacion = nHabitacion;
        this.tipo = tipo;
    }
    

    public Habitacion()
    {;}


    public Integer getIdHabitacion() {
        return nHabitacion;
    }


    public void setIdHabitacion(Integer nHabitacion) {
        this.nHabitacion = nHabitacion;
    }


    public TipoHabitacion getTipo() {
        return tipo;
    }


    public void setTipo(TipoHabitacion tipo) {
        this.tipo = tipo;
    }

    
    
  
    

}
