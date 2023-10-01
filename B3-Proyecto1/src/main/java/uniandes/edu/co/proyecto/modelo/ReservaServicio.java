package uniandes.edu.co.proyecto.modelo;

import java.util.Date;
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

    //CRUD de la reservación de un servicio por parte de un cliente. Un servicio se puede reservar siempre y
//cuando haya disponibilidad. Estas operaciones son realizadas por un cliente. Cada servicio registrado está
//asociado a una habitación y tiene descripción y costo (que ya están establecidos al escoger el servicio a
//registrar) y una fecha (que es escogida por el usuario).

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int numeroReserva;
    private Date fecha;
    

    @ManyToOne
    @JoinColumn(name="idServicio", referencedColumnName = "id")
    private Servicio idServicio;

    @ManyToOne
    @JoinColumn(name="costo", referencedColumnName = "costo")
    private Servicio costo;

    //@ManytoOne
    //@JoinColumn(name="habitacion", referencedColumnName = "id")
    //private Habitacion habitacion;

    public ReservaServicio(int numeroReserva, Date fecha, Servicio idServicio, Servicio costo) {
        this.numeroReserva = numeroReserva;
        this.fecha = fecha;
        this.idServicio = idServicio;
        this.costo = costo;
    }

    public int getNumeroReserva() {
        return numeroReserva;
    }

    public void setNumeroReserva(int numeroReserva) {
        this.numeroReserva = numeroReserva;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }

    public Servicio getCosto() {
        return costo;
    }

    public void setCosto(Servicio costo) {
        this.costo = costo;
    }


    
}
