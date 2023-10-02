package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;

@Entity
@Table(name="Clientes")
public class Cliente extends Usuario{

   

    private Integer numAcompañantes;



    public Cliente(String nombre, Integer numAcompañantes, String tipoDocumento, String correoElectronico){
        super(nombre, tipoDocumento, correoElectronico);
        this.numAcompañantes=numAcompañantes;
    }

    public Cliente()
    {;}

    public Integer getNumAcompañantes(){
        return numAcompañantes;
    }
    public void setNumAcompañantes(Integer numAcompañantes){
        this.numAcompañantes = numAcompañantes;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getTipoDocumento(){
        return tipoDocumento;
    }
    public void setTipoDocumento(String tipoDocumento){
        this.tipoDocumento=tipoDocumento;

    }
    
    

}