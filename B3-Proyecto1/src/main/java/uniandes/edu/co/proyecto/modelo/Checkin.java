package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="Checkins")
public class Checkin {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private Date fechaEntrada;
    @JoinColumn(name="id_responsable", referencedColumnName = "id")
    private Cliente responsable;
    @JoinColumn(name="id_responsableHotel", referencedColumnName = "id")
    private Empleado responsableHotel;

    


    public Checkin(Date fechaEntrada, Cliente responsable, Empleado responsable_hotel) {
        this.fechaEntrada=fechaEntrada;
        this.responsableHotel = responsableHotel;
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
        return responsableHotel;
    }

    public void setResponsableHotel(Empleado responsableHotel) {
        this.responsableHotel = responsableHotel;
    }

    public Cliente getResponsable() {
        return responsable;
    }

    public void setResponsable(Cliente responsable) {
        this.responsable = responsable;
    }
    

    
}