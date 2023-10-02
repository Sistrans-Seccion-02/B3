package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Integer> {
    
    @Query(value="SELECT * FROM restaurantes", nativeQuery = true)
    Collection<Restaurante> darRestaurantes();

    @Query(value = "SELECT * FROM restaurantes WHERE id= : id", nativeQuery= true)
    Restaurante darRestaurante(@Param("id") int id);

    @Modifying
    @Transactional
    //MIRAR EL NEXT VAL
    @Query(value = "INSERT INTO restaurantes (nombre, capacidad, estilo) VALUES (B3-Proyecto1_sequence.nextval, :nombre, :capacidad, :estilo)", nativeQuery = true)
    void insertarRestaurante(@Param("nombre")String nombre, @Param("capacidad")int capacidad, @Param("estilo")String estilo);


    @Modifying
    @Transactional
    @Query(value = "UPDATE restaurantes SET nombre=:nombre, capacidad=:capacidad, estilo=:estilo WHERE id=:id", nativeQuery = true)
    void actualizarRestaurante(@Param("id") int id, @Param("nombre")String nombre, @Param("capacidad")int capacidad, @Param("estilo")String estilo);


    @Modifying
    @Transactional
    @Query(value="DELETE FROM restaurantes WHERE id=:id", nativeQuery = true)
    void eliminaRestaurante(@Param("id") int id); 
    
}