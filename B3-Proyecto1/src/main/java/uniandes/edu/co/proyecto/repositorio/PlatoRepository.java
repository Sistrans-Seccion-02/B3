package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Plato;
import uniandes.edu.co.proyecto.modelo.Servicio;

public interface PlatoRepository extends JpaRepository<Plato, Integer> {
    
    @Query(value="SELECT * FROM platos", nativeQuery = true)
    Collection<Plato> darPlatos();

    @Query(value = "SELECT * FROM platos WHERE id= : id", nativeQuery= true)
    Plato darPlato(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO platos (nombre, costo, idServicio) VALUES (B3-Proyecto1_sequence.nextval, :nombre, :costo, :idServicio)", nativeQuery = true)
    void insertarPlato(@Param("nombre")String nombre, @Param("costo")int costo, @Param("idServicio")Servicio idServicio);


   
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE platos SET nombre =:nombre, costo =:costo, idServicio =:idServicio WHERE id = :id", nativeQuery = true)
    void actualizarPlato(
    @Param("id") int id,
    @Param("nombre") String nombre,
    @Param("costo") int costo,
    @Param("idServicio") Servicio servicio
);


    @Modifying
    @Transactional
    @Query(value="DELETE FROM platos WHERE id=:id", nativeQuery = true)
    void eliminarPlato(@Param("id") int id);


    
}
