package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Usuarios")
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

    public Usuario(String nombre){
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
    public void setCorreoElectronico(){
        this.correoElectronico=correoElectronico;
    }


   

}
