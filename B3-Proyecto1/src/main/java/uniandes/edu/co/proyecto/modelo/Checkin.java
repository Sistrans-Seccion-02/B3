package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Table(name="Checkins")
@Entity
public class Checkin {
    private Date fechaEntrada;
    //no deberia esta conectado a la clase del empleado
    private Empleado responsable_hotel;


    @JoinColumn(name="responsable", referencedColumnName = "responsable")
    private Reserva responsable;


    public Checkin(Date fechaEntrada, Empleado responsable_hotel, Reserva responsable) {
        this.fechaEntrada=fechaEntrada;
        this.responsable_hotel = responsable_hotel;
        this.responsable = responsable;
    }

    public Checkin(){
        ;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setfechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Empleado getResponsableHotel() {
        return responsable_hotel;
    }

    public void setResponsableHotel(Empleado responsable_hotel) {
        this.responsable_hotel = responsable_hotel;
    }

    public Reserva getResponsable() {
        return responsable;
    }

    public void setResponsable(Reserva responsable) {
        this.responsable = responsable;
    }
    

    
}
