package uniandes.edu.co.proyecto.modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="consumos")
public class Consumo {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name="idservicio", referencedColumnName = "idservicio")
    private Servicio idservicio;
    
    @ManyToOne
    @JoinColumn(name="identrada", referencedColumnName = "identrada")
    private Entrada idReserva;

    @ManyToOne
    @JoinColumn(name="habitacion", referencedColumnName = "nhabitacion")
    private Habitacion habitacion;

    public Consumo(Integer id, Servicio idservicio, Entrada idReserva, Habitacion habitacion) {
        this.id = id;
        this.idservicio = idservicio;
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

    public Servicio getidservicio() {
        return idservicio;
    }

    public void setidservicio(Servicio idServicio) {
        this.idservicio = idServicio;
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
