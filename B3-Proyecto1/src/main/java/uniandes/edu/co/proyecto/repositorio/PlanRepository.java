package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Plan;

public interface PlanRepository extends JpaRepository<Plan, Integer>{
    @Query(value = "SELECT * FROM planes", nativeQuery = true)
    Collection<Plan> darPlanes();

    @Query(value = "SELECT * FROM planes WHERE nombre = :nombre", nativeQuery = true)
    Plan darPlan(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO planes (nombre, descripcion, descuento) VALUES ( hotelandes_sequence.nextval, :nombre, :descripcion, :descuento)", nativeQuery = true)
    void insertarPlan( @Param("nombre") String nombre, @Param("descripcion") String descripcion, @Param("descuento") Double descuento) ;

    @Modifying
    @Transactional
    @Query(value = "UPDATE planes SET descripcion =:descripcion, descuento =:descuento WHERE nombre = :nombre", nativeQuery = true)
    void actualizarPlan( @Param("nombre") String nombre, @Param("descripcion") String descripcion, @Param("descuento") Double descuento);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM planes WHERE nombre = :nombre", nativeQuery = true)
    void eliminarPlan(@Param("nombre") String nombre);

    
}
