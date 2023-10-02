package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Table(name="Checkouts")
@Entity
public class Checkout {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Date fechaSalida;
    @JoinColumn(name="id_responsable", referencedColumnName = "id")
    private Cliente responsable;
    @JoinColumn(name="id_responsableHotel", referencedColumnName = "id")
    private Empleado responsableHotel;





    // @JoinColumn(name="responsable", referencedColumnName = "responsable")
    

    public Checkout(Date fechaSalida, Empleado responsableHotel, Cliente responsable) {
        this.fechaSalida = fechaSalida;
        this.responsableHotel = responsableHotel;
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