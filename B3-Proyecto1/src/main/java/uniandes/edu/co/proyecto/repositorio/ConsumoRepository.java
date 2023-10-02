package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Consumo;

public interface ConsumoRepository extends JpaRepository<Consumo, Integer[]> {

    @Query(value = "SELECT * FROM consumos WHERE id = :id", nativeQuery = true)
    Consumo darConsumoPorId(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO consumos (descripcion, costo, fecha, habitacion_id) VALUES (:descripcion, :costo, :fecha, :habitacionId)", nativeQuery = true)
    void registrarConsumo(
        @Param("descripcion") String descripcion,
        @Param("costo") Double costo,
        @Param("fecha") String fecha,
        @Param("habitacionId") Long habitacionId
    );

    @Modifying
    @Transactional
    @Query(value = "UPDATE consumos SET descripcion=:descripcion, costo=:costo, fecha=:fecha, habitacion_id=:habitacionId WHERE id=:id", nativeQuery = true)
    void actualizarConsumo(
        @Param("id") Long id,
        @Param("descripcion") String descripcion,
        @Param("costo") Double costo,
        @Param("fecha") String fecha,
        @Param("habitacionId") int habitacionId
    );

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM consumos WHERE id=:id", nativeQuery = true)
    void eliminarConsumo(@Param("id") int id);
}
