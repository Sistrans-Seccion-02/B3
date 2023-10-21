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

    @Query(value = "SELECT * FROM planes WHERE id = :id", nativeQuery = true)
    Plan darPlan(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO planes (nombre, descripcion, descuento) VALUES ( hotelandes_sequence.nextval, :nombre, :descripcion, :descuento)", nativeQuery = true)
    void insertarPlan( @Param("nombre") String nombre, @Param("descripcion") String descripcion, @Param("descuento") Double descuento) ;

    @Modifying
    @Transactional
    @Query(value = "UPDATE planes SET nombre =:nombre, descripcion =:descripcion, descuento =:descuento WHERE id = :id", nativeQuery = true)
    void actualizarPlan(@Param("id") Integer id, @Param("nombre") String nombre, @Param("descripcion") String descripcion, @Param("descuento") Double descuento);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM planes WHERE id = :id", nativeQuery = true)
    void eliminarPlan(@Param("id") Integer id);

    
}
