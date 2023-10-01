package uniandes.edu.co.proyecto.repositorio;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Usuario;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;




public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
  

    @Query(value="SELECT * FROM clientes", nativeQuery = true)
    Collection<Cliente> darClientes();

    @Query(value = "SELECT * FROM clientes WHERE id= : id", nativeQuery= true)
    Usuario darClienteID(@Param("id") Integer id);
   

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO clientes (nombre) VALUES (B3-Proyecto1_sequence.nextval, :nombre)", nativeQuery = true)
    void insertarCliente(@Param("nombre") String nombre);
   
    @Modifying
    @Transactional
    @Query(value = "UPDATE clientes SET nombre=:nombre WHERE id=:id", nativeQuery = true)
    void actualizarCliente(@Param("id") int id, @Param("nombre") String nombre);


    @Modifying
    @Transactional
    @Query(value="DELETE FROM clientes WHERE id=:id", nativeQuery = true)
    void eliminarCliente(@Param("id") Integer id);
}
