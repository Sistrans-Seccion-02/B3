package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Tienda;

public interface TiendaRepository extends JpaRepository<Tienda, Integer> {
    
    @Query(value="SELECT * FROM tiendas", nativeQuery = true)
    Collection<Tienda> darTiendas();

    @Query(value = "SELECT * FROM tiendas WHERE id= : id", nativeQuery= true)
    Tienda darTienda(@Param("id") int id);

    @Modifying
    @Transactional
    //MIRAR EL NEXT VAL
    @Query(value = "INSERT INTO tiendas (nombre) VALUES (B3-Proyecto1_sequence.nextval, :nombre)", nativeQuery = true)
    void insertarTienda(@Param("nombre")String nombre);


    @Modifying
    @Transactional
    @Query(value = "UPDATE tiendas SET nombre=:nombre WHERE id=:id", nativeQuery = true)
    void actualizarTienda(@Param("id") int id, @Param("nombre")String nombre);


    @Modifying
    @Transactional
    @Query(value="DELETE FROM tiendas WHERE id=:id", nativeQuery = true)
    void eliminarTienda(@Param("id") int id); 
    
}
