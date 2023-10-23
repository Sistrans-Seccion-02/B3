package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import uniandes.edu.co.proyecto.modelo.BebidaBar;
import uniandes.edu.co.proyecto.modelo.Servicio;

public interface BebidaBarRepository extends JpaRepository<BebidaBar, Integer> {
    
    @Query(value="SELECT * FROM bebidas_bares", nativeQuery = true)
    Collection<BebidaBar> darBebidas();

    @Query(value = "SELECT * FROM bebidas_bares WHERE id= : id", nativeQuery= true)
    BebidaBar darBebida(@Param("id") int id);

    @Modifying
    @Transactional
    //MIRAR EL NEXT VAL
    @Query(value = "INSERT INTO bebidas_bares (nombre, costo, idServicio) VALUES (B3-Proyecto1_sequence.nextval, :nombre, :costo, :idServicio)", nativeQuery = true)
    void insertarBebida(@Param("nombre")String nombre, @Param("costo")int costo, @Param("idServicio")Servicio idServicio);

    
    @Modifying
    @Transactional
    @Query(value = "UPDATE bebidas_bares SET nombre=:nombre, costo=:costo, idServicio=:idServicio WHERE id=:id", nativeQuery = true)
    void actualizarBebida(@Param("id") int id, @Param("nombre")String nombre, @Param("costo")int costo, @Param("idServicio")Servicio idServicio);


    @Modifying
    @Transactional
    @Query(value="DELETE FROM bebidas_bares WHERE id=:id", nativeQuery = true)
    void eliminarBebida(@Param("id") int id); 
    
}