package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Lavanderia;

public interface LavanderiaRepository extends JpaRepository<Lavanderia, Integer> {
    
    @Query(value="SELECT * FROM lavanderias", nativeQuery = true)
    Collection<Lavanderia> darLavanderias();

    @Query(value = "SELECT * FROM lavanderias WHERE id= : id", nativeQuery= true)
    Lavanderia darLavanderia(@Param("id") int id);

    @Modifying
    @Transactional
    //MIRAR EL NEXT VAL
    @Query(value = "INSERT INTO lavanderias (prenda, zapatos, costo) VALUES (B3-Proyecto1_sequence.nextval, :prenda, :zapatos, :costo)", nativeQuery = true)
    void insertarLavanderia(@Param("prenda")int prenda, @Param("zapatatos")int zapatos, @Param("costo")int costo);


    @Modifying
    @Transactional
    @Query(value = "UPDATE lavanderias SET prenda=:prenda, zapatos=:zapatos, costo=:costo WHERE id=:id", nativeQuery = true)
    void actualizarLavanderia(@Param("id") int id, @Param("prenda")int prenda, @Param("zapatatos")int zapatos, @Param("costo")int costo);


    @Modifying
    @Transactional
    @Query(value="DELETE FROM lavanderias WHERE id=:id", nativeQuery = true)
    void eliminarLavanderia(@Param("id") int id); 
    
}