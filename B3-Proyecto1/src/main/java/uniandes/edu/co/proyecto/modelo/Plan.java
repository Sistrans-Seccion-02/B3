package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="Planes")
@Entity
public class Plan {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String plan;

    public Plan(String plan){
        this.plan=plan;
    }
    public Plan(){
        ;
    }

    public Integer getId(){
        return id;
    }
    public void setId(){
        this.id=id;
    }
    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }



}