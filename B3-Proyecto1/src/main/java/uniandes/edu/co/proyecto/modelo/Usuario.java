package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    protected Integer id;
    
    protected String nombre;
    protected String tipoDocumento;
    protected String correoElectronico;

    
    public Usuario(){
        ;
    }

    public Usuario(String nombre, String tipoDocumento, String correoElectronico){
        this.nombre=nombre;
        this.tipoDocumento=tipoDocumento;
        this.correoElectronico=correoElectronico;
    }
  
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDocumento(){
        return tipoDocumento;
    }
    public void setTipoDocumento(String tipoDocumento){
        this.tipoDocumento=tipoDocumento;

    }

    public String getCorreoElectronico(){
        return correoElectronico;
    }
    public void setCorreoElectronico(String correoElectronico){
        this.correoElectronico=correoElectronico;
    }


   

}