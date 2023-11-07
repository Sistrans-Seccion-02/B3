package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.Plan;
import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.modelo.Usuario;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    
    public interface Req12{
        int getID_CLIENTE();
        int getYEAR();
        int getDISTINTOS_TRIMESTRES();
        int getNUMERO_DE_ENTRADAS();
    }

    @Query(value="SELECT * FROM reservas", nativeQuery = true)
    Collection<Reserva> darReservas();

    @Query(value = "SELECT * FROM reservas WHERE id= : id", nativeQuery= true)
    Reserva darReserva(@Param("id") int id);

   

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reservas (numPersonas, fechaEntrada, fechaSalida, cliente, habitacion, plan) VALUES (B3-Proyecto1_sequence.nextval, :numPersonas, :fechaEntrada, :fechaSalida, :cliente, :habitacion, :plan)", nativeQuery = true)
    void insertarReserva(@Param("numPersonas") int numpersonas, @Param("fechaEntrada") String fechaEntrada, @Param("fechaSalida") String fechaSalida, @Param("cliente") Usuario Cliente, @Param("habitacion") Habitacion habitacion, @Param("plan") Plan plan);
    

    @Modifying
    @Transactional
    @Query(value = "UPDATE reservas SET numPersonas=:numPersonas, fechaEntrada=:fechaEntrada, fechaSalida=:fechaSalida, cliente=:cliente, habitacion=:habitacion, plan=:plan WHERE id=:id", nativeQuery = true)
    void actualizarReserva(@Param("id") int id, @Param("numPersonas") int numpersonas, @Param("fechaEntrada") String fechaEntrada, @Param("fechaSalida") String fechaSalida, @Param("cliente") Usuario Cliente, @Param("habitacion") Habitacion habitacion, @Param("plan") Plan plan);


    @Modifying
    @Transactional
    @Query(value="DELETE FROM reservas WHERE id=:id", nativeQuery = true)
    void eliminarReserva(@Param("id") int id);

    @Query(value = "SELECT r.IDUSUARIO AS id_cliente, " +
    "TO_CHAR(TO_DATE(r.FECHAENTRADA, 'MM/DD/YYYY'), 'YYYY') AS year, " +
    "COUNT(DISTINCT TO_CHAR(TO_DATE(r.FECHAENTRADA, 'MM/DD/YYYY'), 'Q')) AS distintos_trimestres, " +
    "COUNT(*) AS numero_de_entradas " +
    "FROM RESERVAS r JOIN ENTRADAS e ON r.IDRESERVA = e.IDRESERVA " +
    "GROUP BY r.IDUSUARIO, TO_CHAR(TO_DATE(r.FECHAENTRADA, 'MM/DD/YYYY'), 'YYYY') " +
    "HAVING COUNT(DISTINCT TO_CHAR(TO_DATE(r.FECHAENTRADA, 'MM/DD/YYYY'), 'Q')) = 4 " +
    "ORDER BY id_cliente, year",
nativeQuery = true)
Collection<Req12> findClienteEcelenteEntradas();
    

}