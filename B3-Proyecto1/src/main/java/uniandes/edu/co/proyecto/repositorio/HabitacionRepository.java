package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.TipoHabitacion;

public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> {
    
    @Query(value = "SELECT * FROM habitaciones", nativeQuery = true)
    Collection<Habitacion> darHabitaciones();

    @Query(value = "SELECT * FROM habitaciones WHERE numHabitacion = :numHabitacion", nativeQuery = true)
    Habitacion darHabitacion(@Param("numHabitacion") int numHabitacion);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO habitaciones (numHabitacion, tipo) VALUES (:tipo)", nativeQuery = true)
    void insertarHabitacion(@Param("numHabitacion") int numHabitacion, @Param("tipo") String tipo);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE habitaciones SET tipo = :tipo WHERE numHabitacion = :numHabitacion", nativeQuery = true)
    void actualizarHabitacion(@Param("numHabitacion") int numHabitacion, @Param("tipo") String tipo);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM habitaciones WHERE id = :id", nativeQuery = true)
    void eliminarHabitacion(@Param("numHabitacion") int numHabitacion);
}
