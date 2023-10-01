package uniandes.edu.co.proyecto.modelo;

import java.util.ArrayList;
import java.util.List;

class Administrador {
    
    private List<Habitacion> habitaciones;

    public Administrador() {
        this.habitaciones = new ArrayList<>();
    }

    // CRUD operations
    public void registrarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }

    public Habitacion consultarHabitacion(String tipo) {
        for (Habitacion h : habitaciones) {
            if (h.getTipo().equals(tipo)) {
                return h;
            }
        }
        return null;
    }

    public void actualizarHabitacion(Habitacion habitacionActualizada) {
        for (int i = 0; i < habitaciones.size(); i++) {
            if (habitaciones.get(i).getTipo().equals(habitacionActualizada.getTipo())) {
                habitaciones.set(i, habitacionActualizada);
                break;
            }
        }
    }

    public void borrarHabitacion(String tipo) {
        habitaciones.removeIf(h -> h.getTipo().equals(tipo));
    }
}
