package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Supermercado;

public interface SupermercadoRepository extends JpaRepository<Supermercado, Integer> {
    
    @Query(value="SELECT * FROM supermercados", nativeQuery = true)
    Collection<Supermercado> darSupermercados();

    @Query(value = "SELECT * FROM supermercados WHERE id= : id", nativeQuery= true)
    Supermercado darSupermercado(@Param("id") int id);

    @Modifying
    @Transactional
    //MIRAR EL NEXT VAL
    @Query(value = "INSERT INTO supermercados (nombre) VALUES (B3-Proyecto1_sequence.nextval, :nombre)", nativeQuery = true)
    void insertarSupermercado(@Param("nombre")String nombre);


    @Modifying
    @Transactional
    @Query(value = "UPDATE supermercados SET nombre=:nombre WHERE id=:id", nativeQuery = true)
    void actualizarSupermercado(@Param("id") int id, @Param("nombre")String nombre);


    @Modifying
    @Transactional
    @Query(value="DELETE FROM supermercados WHERE id=:id", nativeQuery = true)
    void eliminarSupermecado(@Param("id") int id); 
    
}
