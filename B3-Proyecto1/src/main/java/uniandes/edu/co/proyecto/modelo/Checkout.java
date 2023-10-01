package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Table(name="Checkouts")
@Entity
public class Checkout {
    private Date fechaSalida;
    //no deberia esta conectado a la clase del empleado
    private Empleado responsable_hotel;


    @JoinColumn(name="responsable", referencedColumnName = "responsable")
    private Reserva responsable;

    public Checkout(Date fechaSalida, Empleado responsable_hotel, Reserva responsable) {
        this.fechaSalida = fechaSalida;
        this.responsable_hotel = responsable_hotel;
        this.responsable = responsable;
    }

    public Checkout(){
        ;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setfechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
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
