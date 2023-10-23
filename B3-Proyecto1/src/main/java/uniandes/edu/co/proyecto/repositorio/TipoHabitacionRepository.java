package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.TipoHabitacion;

public interface TipoHabitacionRepository extends JpaRepository<TipoHabitacion, Long> {

    @Query(value = "SELECT * FROM tipo_habitacion WHERE id = :id", nativeQuery = true)
    TipoHabitacion darTipoHabitacion(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tipo_habitacion (nombre, dotacion, capacidad) VALUES (:nombre, :dotacion, :capacidad)", nativeQuery = true)
    void insertarTipoHabitacion(@Param("nombre") String nombre, @Param("dotacion") Integer dotacion, @Param("capacidad") int capacidad);

    @Modifying
    @Transactional
    @Query(value = "UPDATE tipo_habitacion SET nombre=:nombre, dotacion=:dotacion, capacidad=:capacidad WHERE id=:id", nativeQuery = true)
    void actualizarTipoHabitacion(@Param("id") int id, @Param("nombre") String nombre, @Param("dotacion") Integer dotacion, @Param("capacidad") int capacidad);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tipo_habitacion WHERE id=:id", nativeQuery = true)
    void eliminarTipoHabitacion(@Param("id") int id);
}
