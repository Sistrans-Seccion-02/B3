package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.ProductoTienda;
import uniandes.edu.co.proyecto.modelo.Servicio;
import uniandes.edu.co.proyecto.modelo.Tienda;

public interface ProductoTiendaRepository extends JpaRepository<ProductoTienda, Integer> {
    
    @Query(value="SELECT * FROM productos_tienda", nativeQuery = true)
    Collection<ProductoTienda> darProductos();

    @Query(value = "SELECT * FROM productos_tienda WHERE id= : id", nativeQuery= true)
    ProductoTienda darProducto(@Param("id") int id);

   @Modifying
    @Transactional
    @Query(value = "INSERT INTO productos_tienda (nombre, costo, idServicio) VALUES (B3-Proyecto1_sequence.nextval, :nombre, :costo, :idServicio)", nativeQuery = true)
    void insertarProducto(@Param("nombre")String nombre, @Param("costo")int costo, @Param("idServicio")Tienda idServicio);


    @Modifying
    @Transactional
    @Query(value = "UPDATE productos_tienda SET nombre=:nombre, costo=:costo, idServicio=:idServicio WHERE id=:id", nativeQuery = true)
    void actualizarProducto(@Param("id") int id, @Param("nombre")String nombre, @Param("costo")int costo, @Param("idServicio")Tienda idServicio);


    @Modifying
    @Transactional
    @Query(value="DELETE FROM productos_tienda WHERE id=:id", nativeQuery = true)
    void eliminarProducto(@Param("id") int id);

}
