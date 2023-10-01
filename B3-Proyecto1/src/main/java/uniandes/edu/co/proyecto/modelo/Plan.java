package uniandes.edu.co.proyecto.modelo;

public class Plan {
    
    private String nombre;
    private double costoTotal; // Costo fijo total
    private Consumo consumo;
    
    // Constructor
    public Plan(int id, String nombre, double costoTotal, Consumo consumo) {
        this.nombre = nombre;
        this.costoTotal = costoTotal;
        this.consumo = consumo;
    }

    // Métodos getters y setters
    // ... (aquí deberías agregar todos los getters y setters para cada atributo)

    @Override
    public String toString() {
        return "Plan{" +
                "nombre='" + nombre + '\'' +
                ", costoTotal=" + costoTotal +
                ", consumo=" + consumo +
                '}';
    }

    public Plan()
    {;}
    //getter y setter
    public String getNombre() {
        return nombre;
    }
    public double getCostoTotal() {
        return costoTotal;
    }
    public Consumo getConsumo() {
        return consumo;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }
    public void setConsumo(Consumo consumo) {
        this.consumo = consumo;
    }
}

