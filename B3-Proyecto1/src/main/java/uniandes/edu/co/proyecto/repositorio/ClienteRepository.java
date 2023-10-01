package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query(value = "SELECT * FROM clientes WHERE id_cliente = :idCliente", nativeQuery = true)
    Cliente darCliente(@Param("idCliente") String idCliente);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO clientes ( nombre, reserva_id, id_cliente) VALUES (:nombre, :reservaId, :idCliente)", nativeQuery = true)
    void registrarCliente(
        @Param("nombre") String nombre, 
        @Param("reservaId") String reservaId,
        @Param("idCliente") String idCliente

    );

    @Modifying
    @Transactional
    @Query(value = "UPDATE clientes SET nombre=:nombre, reserva_id=:reservaId WHERE id_cliente=:idCliente", nativeQuery = true)
    void actualizarCliente(
        @Param("idCliente") String idCliente,
        @Param("nombre") String nombre, 
        @Param("reservaId") String reservaId
    );

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM clientes WHERE id_cliente=:idCliente", nativeQuery = true)
    void eliminarCliente(@Param("idCliente") String idCliente);
}
