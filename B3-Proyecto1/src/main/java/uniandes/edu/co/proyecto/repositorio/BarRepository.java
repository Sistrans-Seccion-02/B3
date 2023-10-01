package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Bar;

public interface BarRepository extends JpaRepository<Bar, Integer> {
    
    @Query(value="SELECT * FROM bares", nativeQuery = true)
    Collection<Bar> darBares();

    @Query(value = "SELECT * FROM bares WHERE id= : id", nativeQuery= true)
    Bar darBar(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO bares (capacidad, estilo) VALUES (B3-Proyecto1_sequence.nextval, :capacidad, :estilo)", nativeQuery = true)
    void insertarBar(@Param("capacidad")int capacidad, @Param("estilo")String estilo);


    @Modifying
    @Transactional
    @Query(value = "UPDATE bares SET capacidad=:capacidad, estilo=:estilo WHERE id=:id", nativeQuery = true)
    void actualizarrBar(@Param("id") int id, @Param("capacidad")int capacidad, @Param("estilo")String estilo);


    @Modifying
    @Transactional
    @Query(value="DELETE FROM bares WHERE id=:id", nativeQuery = true)
    void eliminarBar(@Param("id") int id);


    
}
