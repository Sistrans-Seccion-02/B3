package uniandes.edu.co.proyecto.modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table(name="Reservas")
@Entity
public class Reserva {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idreserva;
    
    private int numPersonas;
    private String fechaEntrada;
    private String fechaSalida;

    @OneToOne
    @JoinColumn(name="idusuario", referencedColumnName = "idusuario")
    private Usuario cliente;

    @ManyToOne
    @JoinColumn(name="nhabitacion", referencedColumnName = "nhabitacion")
    private Habitacion habitacion;

    @ManyToOne
    @JoinColumn(name="tipoplan", referencedColumnName = "nombre")
    private Plan tipoPlan;

    public Reserva(Integer idreserva, int numPersonas, String fechaEntrada, String fechaSalida, Usuario cliente,
            Habitacion habitacion, Plan tipoPlan) {
        this.idreserva = idreserva;
        this.numPersonas = numPersonas;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.tipoPlan = tipoPlan;
    }

    public Reserva()
    {;}

    public Integer getId_reserva() {
        return idreserva;
    }

    public void setId_reserva(Integer id_reserva) {
        this.idreserva = id_reserva;
    }

    public int getNumPersonas() {
        return numPersonas;
    }

    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Plan getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(Plan tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    
    
    
}