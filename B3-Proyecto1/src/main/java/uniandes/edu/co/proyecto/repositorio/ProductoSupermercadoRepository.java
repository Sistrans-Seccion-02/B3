package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.ProductoSupermercado;
import uniandes.edu.co.proyecto.modelo.Servicio;

public interface ProductoSupermercadoRepository extends JpaRepository<ProductoSupermercado, Integer> {
    
    @Query(value="SELECT * FROM productos_supermercado", nativeQuery = true)
    Collection<ProductoSupermercado> darProductos();

    @Query(value = "SELECT * FROM productos_supermercado WHERE id= : id", nativeQuery= true)
    ProductoSupermercado darProducto(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO productos_supermercado (nombre, costo, idServicio) VALUES (B3-Proyecto1_sequence.nextval, :nombre, :costo, :idServicio)", nativeQuery = true)
    void insertarProducto(@Param("nombre")String nombre, @Param("costo")int costo, @Param("idServicio")Servicio idServicio);


    @Modifying
    @Transactional
    @Query(value = "UPDATE productos_supermercado SET nombre=:nombre, costo=:costo, idServicio=:idServicio WHERE id=:id", nativeQuery = true)
    void actualizarProducto(@Param("id") int id, @Param("nombre")String nombre, @Param("costo")int costo, @Param("idServicio")Servicio idServicio);


    @Modifying
    @Transactional
    @Query(value="DELETE FROM productos_supermercado WHERE id=:id", nativeQuery = true)
    void eliminarProducto(@Param("id") int id);

}
