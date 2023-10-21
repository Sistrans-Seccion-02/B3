package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import uniandes.edu.co.proyecto.modelo.TipoHabitacion;

@Entity
@Table(name="habitaciones")
public class Habitacion {
    
    // Atributos de la habitación
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @JoinColumn(name="tipo", referencedColumnName = "nombre")
    private TipoHabitacion tipo;  // Ejemplo: "Suite", "Doble", "Sencilla"
  
    // Constructor
    public Habitacion(TipoHabitacion tipo, int id) {
        this.tipo = tipo;
        this.id = id;

    }
    public Habitacion()
    {;}

    // Métodos getters y setters
    //getter y setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public TipoHabitacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoHabitacion tipo) {
        this.tipo = tipo;
    }

}
