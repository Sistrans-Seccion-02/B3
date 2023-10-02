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
    @Query(value = "INSERT INTO planes (plan) VALUES ( hotelandes_sequence.nextval, :nombre)", nativeQuery = true)
    void insertarPlan( @Param("plan") String plan);

    @Modifying
    @Transactional
    @Query(value = "UPDATE planes SET plan = :nombre WHERE id = :id", nativeQuery = true)
    void actualizarPlan(@Param("id") Integer id, @Param("plan") String plan);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM planes WHERE id = :id", nativeQuery = true)
    void eliminarPlan(@Param("id") Integer id);

    
}
