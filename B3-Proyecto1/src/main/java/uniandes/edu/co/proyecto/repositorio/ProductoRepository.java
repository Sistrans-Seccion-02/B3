package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.modelo.Servicio;
import uniandes.edu.co.proyecto.modelo.Supermercado;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    
    @Query(value="SELECT * FROM productos", nativeQuery = true)
    Collection<Producto> darProductos();

    @Query(value = "SELECT * FROM productos WHERE id= : id", nativeQuery= true)
    Producto darProducto(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO productos (nombre, costo, idServicio) VALUES (B3-Proyecto1_sequence.nextval, :nombre, :costo, :idServicio)", nativeQuery = true)
    void insertarProducto(@Param("nombre")String nombre, @Param("costo")int costo, @Param("idServicio")Servicio idServicio);


    @Modifying
    @Transactional
    @Query(value = "UPDATE productos SET nombre=:nombre, costo=:costo, idServicio=:idServicio WHERE id=:id", nativeQuery = true)
    void actualizarProducto(@Param("id") int id, @Param("nombre")String nombre, @Param("costo")int costo, @Param("idServicio")Servicio idServicio);


    @Modifying
    @Transactional
    @Query(value="DELETE FROM productos WHERE id=:id", nativeQuery = true)
    void eliminarProducto(@Param("id") int id);

}
