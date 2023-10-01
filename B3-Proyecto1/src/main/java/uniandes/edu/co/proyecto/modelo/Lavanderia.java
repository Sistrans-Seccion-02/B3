package uniandes.edu.co.proyecto.modelo;

public class Lavanderia extends Servicio{

    private char zapatos;
    private char prenda;
    private int costo;

public Lavanderia(char zapatos, char prenda, int costo) {
    this.zapatos = zapatos;
    this.prenda = prenda;
    this.costo = costo;
}

public Lavanderia()
{;}

public char getZapatos() {
    return zapatos;
}

public void setZapatos(char zapatos) {
    this.zapatos = zapatos;
}

public char getPrenda() {
    return prenda;
}

public void setPrenda(char prenda) {
    this.prenda = prenda;
}

public int getCosto() {
    return costo;
}

public void setCosto(int costo) {
    this.costo = costo;
}
    
    
}
