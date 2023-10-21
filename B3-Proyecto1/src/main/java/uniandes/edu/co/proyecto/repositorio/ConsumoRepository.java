package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import uniandes.edu.co.proyecto.modelo.Consumo;
import uniandes.edu.co.proyecto.modelo.Entrada;
import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.Servicio;

public interface ConsumoRepository extends JpaRepository<Consumo, Integer> {

    @Query(value="SELECT * FROM consumos", nativeQuery = true)
    Collection<Consumo> darConsumos();
    
    @Query(value = "SELECT * FROM consumos WHERE id = :id", nativeQuery = true)
    Consumo darConsumo(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO consumos (idServicio, idReserva, numHabitacion) VALUES (:idServicio, :idReserva, :numHbitacion)", nativeQuery = true)
    void insertarConsumo(
        @Param("idServicio") Servicio id_servicio,
        @Param("idReserva") Entrada id_reserva,
        @Param("numHabitacion") Habitacion numHabitacion
    );

    @Modifying
    @Transactional
    @Query(value = "UPDATE consumos SET idServicio=:idServicio, idReserva=:idReserva, numHabitacion=:numHabitacion WHERE id=:id", nativeQuery = true)
    void actualizarConsumo(
        @Param("id") int id,
        @Param("idServicio") Servicio id_servicio,
        @Param("idReserva") Entrada id_reserva,
        @Param("numHabitacion") Habitacion numHabitacion
    );

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM consumos WHERE id=:id", nativeQuery = true)
    void eliminarConsumo(@Param("id") int id);
}
