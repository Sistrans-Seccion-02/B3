package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Table(name="reservas")
@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String tipo;
    private Date fechaEntrada;
    private Date fechaSalida;
    private String responsable;


    @ManyToOne
    @JoinColumn(name="nombre_hotel", referencedColumnName = "nombre")
    private Hotel nombre_hotel;


    //@ManytoOne
    //@JoinColumn(name="planReserva", referencedColumnName = "plan")
    //private Plan planReserva;

    //@ManytoOne
    //@JoinColumn(name="id_cliente", referencedColumnName = "id")
    //private Cliente id_cliente;

    //@ManytoOne
    //@JoinColumn(name="checkin_id", referencedColumnName = "id")
    //private Check-In checkin_id;
    
    //@ManytoOne
    //@JoinColumn(name="checkout_id", referencedColumnName = "id")
    //private Check-Out checkout_id;

    public Reserva(Integer id, String tipo, Date fechaEntrada, Date fechaSalida, String responsable,
            Hotel nombre_hotel) {
        this.id = id;
        this.tipo = tipo;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.responsable = responsable;
        this.nombre_hotel = nombre_hotel;
    }



    public Integer getId() {
        return id;
    }



    public void setId(Integer id) {
        this.id = id;
    }



    public String getTipo() {
        return tipo;
    }



    public void setTipo(String tipo) {
        this.tipo = tipo;
    }



    public Date getFechaEntrada() {
        return fechaEntrada;
    }



    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }



    public Date getFechaSalida() {
        return fechaSalida;
    }



    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }



    public String getResponsable() {
        return responsable;
    }



    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }



    public Hotel getNombre_hotel() {
        return nombre_hotel;
    }



    public void setNombre_hotel(Hotel nombre_hotel) {
        this.nombre_hotel = nombre_hotel;
    }

    

    

    


    
}
