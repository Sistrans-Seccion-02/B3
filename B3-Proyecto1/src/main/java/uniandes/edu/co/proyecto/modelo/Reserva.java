package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Table(name="Reservas")
@Entity
public class Reserva {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;


    @JoinColumn(name="fechaEntrada", referencedColumnName = "fechaEntrada")
    private Checkin fechaEntrada;

    @JoinColumn(name="fechaSalida", referencedColumnName = "fechaSalida")
    private Checkout fechaSalida;


    
    @JoinColumn(name="idCliente", referencedColumnName = "responsable")
    private Cliente responsable;
    
    @JoinColumn(name="tipoPlan", referencedColumnName = "plan")
    private Plan tipoPlan;

    private int numPersonas;

    public Reserva(Cliente responsable, Plan tipoPlan, Checkin fechaEntrada, Checkout fechaSalida, int numPersonas){
        this.responsable = responsable;
        this.tipoPlan = tipoPlan;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.numPersonas=numPersonas;
    }

    public Reserva(){
        ;
    }

    public Integer getId(){
        return id;
    }
    public void setId(){
        this.id=id;
    }

    public Cliente getResponsable(){
        return responsable;
    }
    public void setResponsable(){
        this.responsable=responsable;
    }
    
    public Plan getTipoPlan(){
        return tipoPlan;
    }
    public void setTipoPlan(){
        this.tipoPlan=tipoPlan;
    }

    public Checkin getFechaEntrada(){
        return fechaEntrada;
    }
    public void setfechaEntrada(){
        this.fechaEntrada=fechaEntrada;
    }
     public Checkout getFechaSalida(){
        return fechaSalida;
    }
    public void setfechaSalida(){
        this.fechaSalida=fechaSalida;
    }

    public int getNumPersonas(){
        return numPersonas;
    }
    public void setNumPersonas(){
        this.numPersonas=numPersonas;
    }
    
}