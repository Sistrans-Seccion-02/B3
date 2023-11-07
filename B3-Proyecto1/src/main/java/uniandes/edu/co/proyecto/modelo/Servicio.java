package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Table;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.DiscriminatorColumn;


@Entity
@Table(name="servicios")
public class Servicio {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer idservicio;

    @Column(insertable=false, updatable=false)
    public String dtype;
    public String nombre;
    public int costoservicio;

    

    

    public Servicio(Integer idservicio, String dtype, String nombre, int costoservicio, String costo) {
        this.idservicio = idservicio;
        this.dtype = dtype;
        this.nombre = nombre;
        this.costoservicio = costoservicio;
    }

    public Servicio()
    {;}

    public Integer getidservicio() {
        return idservicio;
    }

    public void setidservicio(Integer idservicio) {
        this.idservicio = idservicio;
    }

    public String getdtype() {
        return dtype;
    }

    public void setdtype(String dtype) {
        this.dtype = dtype;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCostoservicio() {
        return costoservicio;
    }

    public void setCostoservicio(int costoservicio) {
        this.costoservicio = costoservicio;
    }


    
    



}
