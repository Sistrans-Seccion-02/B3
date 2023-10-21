package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="entradas")
public class Entrada {
    @Id
    @ManyToOne
    @JoinColumn(name="idReserva", referencedColumnName = "id_reserva")
    private Servicio idServicio;

    @ManyToOne
    @JoinColumn(name="idEncargado", referencedColumnName = "id_usuario")
    private Usuario idEncargado;

    public Entrada(Servicio idServicio, Usuario idEncargado) {
        this.idServicio = idServicio;
        this.idEncargado = idEncargado;
    }

    public Entrada()
    {;}

    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }

    public Usuario getIdEncargado() {
        return idEncargado;
    }

    public void setIdEncargado(Usuario idEncargado) {
        this.idEncargado = idEncargado;
    } 

    

    
}
