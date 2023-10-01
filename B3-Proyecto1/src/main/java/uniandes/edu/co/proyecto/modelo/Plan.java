package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(name="Planes")
@Entity
public class Plan {
    private String plan;

    public Plan(String plan){
        this.plan=plan;
    }


    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }



}
