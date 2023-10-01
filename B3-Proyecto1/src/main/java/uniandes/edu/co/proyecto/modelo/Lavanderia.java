package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Table(name="lavanderias")
@Entity

public class Lavanderia extends Servicio{

    private int zapatos;
    private int prenda;
    private int costo;

public Lavanderia(int prenda, int zapatos, int costo) {
    this.zapatos = zapatos;
    this.prenda = prenda;
    this.costo = costo;
}

public Lavanderia()
{;}

public int getZapatos() {
    return zapatos;
}

public void setZapatos(int zapatos) {
    this.zapatos = zapatos;
}

public int getPrenda() {
    return prenda;
}

public void setPrenda(int prenda) {
    this.prenda = prenda;
}

public int getCosto() {
    return costo;
}

public void setCosto(int costo) {
    this.costo = costo;
}
    
    
}
