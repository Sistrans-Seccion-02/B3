package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="consumos")
public class Consumo {

    @JoinColumn(name="id_consumo", referencedColumnName = "servicios")
    private Servicio consumo;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String descripcion;
    private Double costo;
    private Date fecha;
    private int habitacioId;

    // Constructor
    
    public Consumo(Servicio consumo, String descripcion, Double costo, Date fecha, int habitacioId, int id) {    
        this.consumo = consumo;
        this.descripcion = descripcion;
        this.costo = costo;
        this.fecha = fecha;
        this.habitacioId = habitacioId;
        this.id = id;
    }
    public Consumo() 
    {;}

    // Getters y Setters
    public Servicio getConsumo() {
        return consumo;
    }
    public void setConsumo(Servicio consumo) {
        this.consumo = consumo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;    
    }
    public Double getCosto() {
        return costo;
    }
    public void setCosto(Double costo) {
        this.costo = costo;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;    
    }
    public int getHabitacioId() {
        return habitacioId;
    }
    public void setHabitacioId(int habitacioId) {
        this.habitacioId = habitacioId;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;    
    }



}
