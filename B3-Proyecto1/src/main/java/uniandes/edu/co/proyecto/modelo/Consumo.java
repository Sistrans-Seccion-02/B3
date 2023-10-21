package uniandes.edu.co.proyecto.modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="consumos")
public class Consumo {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    @JoinColumn(name="id_servicio", referencedColumnName = "id_servicio")
    private Servicio idServicio;

    @JoinColumn(name="id_reserva", referencedColumnName = "id_reserva")
    private Entrada idReserva;

    @JoinColumn(name="numHabitacion", referencedColumnName = "nHabitacion")
    private Habitacion habitacion;

    public Consumo(Integer id, Servicio idServicio, Entrada idReserva, Habitacion habitacion) {
        this.id = id;
        this.idServicio = idServicio;
        this.idReserva = idReserva;
        this.habitacion = habitacion;
    }

    public Consumo()
    {
        ;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }

    public Entrada getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Entrada idReserva) {
        this.idReserva = idReserva;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    

    

}
