package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="reservas_servicio")
@Entity
public class ReservaServicio {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String fecha;
    private String hora;

    @ManyToOne
    @JoinColumn(name="idservicio", referencedColumnName = "idservicio")
    private Servicio idservicio;

    @ManyToOne
    @JoinColumn(name="habitacion", referencedColumnName = "nhabitacion")
    private Habitacion habitacion;

    public ReservaServicio(Integer id, String fecha, String hora, Servicio idservicio, Habitacion habitacion) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.idservicio = idservicio;
        this.habitacion = habitacion;
    }

    public ReservaServicio()
    {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Servicio getidservicio() {
        return idservicio;
    }

    public void setidservicio(Servicio idServicio) {
        this.idservicio = idServicio;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    
    
}
