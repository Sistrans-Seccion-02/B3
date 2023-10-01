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

    @Query(value = "SELECT * FROM habitaciones WHERE id = :id", nativeQuery = true)
    Habitacion darHabitacion(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO habitaciones (id, tipo_id, dotacion, capacidad) VALUES (:id, :tipoId, :dotacion, :capacidad)", nativeQuery = true)
    void insertarHabitacion(@Param("id") int id, @Param("tipoId") int tipoId, @Param("dotacion") String dotacion, @Param("capacidad") int capacidad);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE habitaciones SET tipo_id = :tipoId, dotacion = :dotacion, capacidad = :capacidad WHERE id = :id", nativeQuery = true)
    void actualizarHabitacion(@Param("id") int id, @Param("tipoId") int tipoId, @Param("dotacion") String dotacion, @Param("capacidad") int capacidad);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM habitaciones WHERE id = :id", nativeQuery = true)
    void eliminarHabitacion(@Param("id") int id);
}
