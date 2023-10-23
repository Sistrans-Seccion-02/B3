package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="entradas")
public class Entrada {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id_entrada;

    @OneToOne
    @JoinColumn(name="idReserva", referencedColumnName = "id_reserva")
    private Reserva idReserva;

    @ManyToOne
    @JoinColumn(name="idEncargado", referencedColumnName = "id_usuario")
    private Usuario idEncargado;

    public Entrada(Reserva idReserva, Usuario idEncargado) {
        this.idReserva = idReserva;
        this.idEncargado = idEncargado;
    }

    public Entrada()
    {;}

    public int getId_entrada() {
        return id_entrada;
    }

    public void setId_entrada(int id_entrada) {
        this.id_entrada = id_entrada;
    }

    public Reserva getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Reserva idReserva) {
        this.idReserva = idReserva;
    }

    public Usuario getIdEncargado() {
        return idEncargado;
    }

    public void setIdEncargado(Usuario idEncargado) {
        this.idEncargado = idEncargado;
    }

  
    

    
}
