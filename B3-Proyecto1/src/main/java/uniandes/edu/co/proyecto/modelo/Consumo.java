package uniandes.edu.co.proyecto.modelo;

public class Consumo {
    
    private double descuentoAlojamiento; // Porcentaje de descuento en el alojamiento
    private double descuentoBarRestaurante; // Porcentaje de descuento en consumos de bar y restaurante
    private boolean incluyeAlimentacion;
    private int limiteBebidas; // Por ejemplo: 3 cervezas diarias
    
    // Constructor
    public Consumo(double descuentoAlojamiento, double descuentoBarRestaurante, boolean incluyeAlimentacion, int limiteBebidas) {
        this.descuentoAlojamiento = descuentoAlojamiento;
        this.descuentoBarRestaurante = descuentoBarRestaurante;
        this.incluyeAlimentacion = incluyeAlimentacion;
        this.limiteBebidas = limiteBebidas;
    }

    // Métodos getters y setters
    // ... (aquí deberías agregar todos los getters y setters para cada atributo)

    @Override
    public String toString() {
        return "Consumo{" +
                "descuentoAlojamiento=" + descuentoAlojamiento +
                ", descuentoBarRestaurante=" + descuentoBarRestaurante +
                ", incluyeAlimentacion=" + incluyeAlimentacion +
                ", limiteBebidas=" + limiteBebidas +
                '}';
    }
}
