package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Spa;

public interface SpaRepository extends JpaRepository<Spa, Integer> {
    
    @Query(value="SELECT * FROM spas", nativeQuery = true)
    Collection<Spa> darSpas();

    @Query(value = "SELECT * FROM spas WHERE id= : id", nativeQuery= true)
    Spa darSpa(@Param("id") int id);

    @Modifying
    @Transactional
    //MIRAR EL NEXT VAL
    @Query(value = "INSERT INTO spas (nombre, costo, duracion) VALUES (B3-Proyecto1_sequence.nextval, :nombre, :costo, :duracion)", nativeQuery = true)
    void insertarSpa(@Param("nombre")String nombre, @Param("costo")int costo,@Param("duracion")int duracion);


    @Modifying
    @Transactional
    @Query(value = "UPDATE spas SET costo=:costo, duracion=:duracion WHERE id=:id", nativeQuery = true)
    void actualizarSpa(@Param("id") int id, @Param("nombre")String nombre, @Param("costo")int costo,@Param("duracion")int duracion);



    @Modifying
    @Transactional
    @Query(value="DELETE FROM spas WHERE id=:id", nativeQuery = true)
    void eliminarSpa(@Param("id") int id); 
    
}
