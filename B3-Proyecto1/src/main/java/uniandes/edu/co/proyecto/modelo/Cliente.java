package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;

@MappedSuperclass
@Table(name="Clientes")
@Entity
public class Cliente extends Usuario{

   
    private Integer numAcompañantes;

    public Cliente(){
        ;
    }

    public Cliente(String nombre, Integer numAcompañantes){
        super(nombre);
        this.numAcompañantes=numAcompañantes;
    }



    public Integer getNumAcompañantes(){
        return numAcompañantes;
    }

    public void setNumAcompañantes(){
        this.numAcompañantes=numAcompañantes;
    }
    

}
