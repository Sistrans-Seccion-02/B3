package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Entrada;
import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.modelo.Usuario;

public interface EntradaRepository extends JpaRepository<Entrada, Integer> {
    


    @Query(value="SELECT * FROM entradas", nativeQuery = true)
    Collection<Entrada> darEntradas();

    @Query(value = "SELECT * FROM entradas WHERE id_entrada= : id_entrada", nativeQuery= true)
    Entrada darEntrada(@Param("id_entrada") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO entradas (idReserva, idUsuario) VALUES (B3-Proyecto1_sequence.nextval, :idReserva, :idUsuario)", nativeQuery = true)
    void insertarEntrada(@Param("idReserva")Reserva idReserva, @Param("idUsuario")Usuario idUsuario);


    @Modifying
    @Transactional
    @Query(value = "UPDATE entradas SET idReserva=:idReserva, idUsuario=:idUsuario WHERE id_entrada=:id_entrada", nativeQuery = true)
    void actualizarEntrada(
    @Param("id_entrada") int idEntrada,
    @Param("idReserva") Reserva reserva,
    @Param("idUsuario") Usuario usuario
    );


    @Modifying
    @Transactional
    @Query(value="DELETE FROM entradas WHERE id_entrada=:id_entrada", nativeQuery = true)
    void eliminarEntrada(@Param("id_entrada") int id_entrada);
    



}

