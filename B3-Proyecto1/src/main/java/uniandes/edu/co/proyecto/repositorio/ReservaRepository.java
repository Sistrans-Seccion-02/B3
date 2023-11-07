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

    public interface RespuestaInformacionMayorOcupacion {
        String getFECHA();
        Integer getOCUPACION();
        
    }

    public interface RespuestaInformacionMenorOcupacion {
        String getFECHA();
        Integer getOCUPACION();
        
    }

    public interface RespuestaInformacionMayoresIngresos {
        String getFECHA();
        Integer getINGRESOS();
        
    }
    
    public interface RespuestaInformacionServiciosMasSolicitados {
        Integer getSEMANA();
        Integer getIDSERVICIO();
        Integer getSOLICITUDES_SERVICIO();
        Integer getCONSUMO();

        
    }


    public interface RespuestaInformacionServiciosMenosSolicitados {
        Integer getSEMANA();
        Integer getIDSERVICIO();
        Integer getSOLICITUDES_SERVICIO();
        Integer getCONSUMO();
        
    }

    public interface RespuestaInformacionHabitacionesMasSolicitadas {
        Integer getSEMANA();
        Integer getNHABITACION();
        Integer getCANTIDAD_HABITACION();
        
    }

    public interface RespuestaInformacionHabitacionesMenosSolicitadas {
        Integer getSEMANA();
        Integer getNHABITACION();
        Integer getCANTIDAD_HABITACION();
        
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


@Query(value="SELECT FECHAENTRADA AS FECHA, COUNT (*) AS OCUPACION " +//
                  "FROM RESERVAS "+//
                  "GROUP BY FECHAENTRADA "+//
                  "ORDER BY OCUPACION DESC "+//
                  "FETCH FIRST 5 ROW ONLY ", nativeQuery = true)
    Collection<RespuestaInformacionMayorOcupacion> darMayorOcupacion();

@Query(value="SELECT FECHAENTRADA AS FECHA, COUNT (*) AS OCUPACION " +//
                  "FROM RESERVAS "+//
                  "GROUP BY FECHAENTRADA "+//
                  "ORDER BY OCUPACION ASC "+//
                  "FETCH FIRST 5 ROW ONLY ", nativeQuery = true)
    Collection<RespuestaInformacionMenorOcupacion> darMenorOcupacion();

@Query(value="SELECT FECHAENTRADA AS FECHA, SUM(COSTOSERVICIO) AS INGRESOS " +//
                  "FROM CONSUMOS "+//
                  "INNER JOIN SERVICIOS ON CONSUMOS.IDSERVICIO=SERVICIOS.IDSERVICIO "+//
                  "INNER JOIN ENTRADAS ON ENTRADAS.IDENTRADA=CONSUMOS.IDENTRADA "+//
                  "INNER JOIN RESERVAS ON RESERVAS.IDRESERVA=ENTRADAS.IDRESERVA "+//
                  "GROUP BY FECHAENTRADA "+//
                  "ORDER BY INGRESOS DESC "+//
                  "FETCH FIRST 5 ROW ONLY ", nativeQuery = true)
    Collection<RespuestaInformacionMayoresIngresos> darMayoresIngresos();


@Query(value="SELECT TO_CHAR(TO_DATE(FECHAENTRADA, 'MM/DD/YYYY'), 'WW') AS SEMANA, S.IDSERVICIO AS IDSERVICIO , COUNT(S.IDSERVICIO) AS SOLICITUDES_SERVICIO, SUM(COSTOSERVICIO) AS CONSUMO " +//
                  "FROM RESERVAS R "+//
                  "INNER JOIN ENTRADAS E ON R.IDRESERVA=E.IDRESERVA "+//
                  "INNER JOIN CONSUMOS C ON C.IDENTRADA=E.IDENTRADA "+//
                  "INNER JOIN SERVICIOS S ON S.IDSERVICIO=C.IDSERVICIO "+//
                  "WHERE TO_CHAR(TO_DATE(FECHAENTRADA, 'MM/DD/YYYY'), 'WW')= :semana "+//
                  "GROUP BY TO_CHAR(TO_DATE(FECHAENTRADA, 'MM/DD/YYYY'), 'WW'), S.IDSERVICIO "+//
                  "ORDER BY COUNT(S.IDSERVICIO) DESC "+//
                  "FETCH FIRST 1 ROW ONLY", nativeQuery = true)
    Collection<RespuestaInformacionServiciosMasSolicitados> darServiciosMasSolicitados(@Param("semana") int id);

@Query(value="SELECT TO_CHAR(TO_DATE(FECHAENTRADA, 'MM/DD/YYYY'), 'WW') AS SEMANA, S.IDSERVICIO AS IDSERVICIO , COUNT(S.IDSERVICIO) AS SOLICITUDES_SERVICIO, SUM(COSTOSERVICIO) AS CONSUMO " +//
                  "FROM RESERVAS R "+//
                  "INNER JOIN ENTRADAS E ON R.IDRESERVA=E.IDRESERVA "+//
                  "INNER JOIN CONSUMOS C ON C.IDENTRADA=E.IDENTRADA "+//
                  "INNER JOIN SERVICIOS S ON S.IDSERVICIO=C.IDSERVICIO "+//
                  "WHERE TO_CHAR(TO_DATE(FECHAENTRADA, 'MM/DD/YYYY'), 'WW')= :semana "+//
                  "GROUP BY TO_CHAR(TO_DATE(FECHAENTRADA, 'MM/DD/YYYY'), 'WW'), S.IDSERVICIO "+//
                  "ORDER BY COUNT(S.IDSERVICIO) ASC "+//
                  "FETCH FIRST 1 ROW ONLY", nativeQuery = true)
    Collection<RespuestaInformacionServiciosMenosSolicitados> darServiciosMenosSolicitados(@Param("semana") int id);







@Query(value="SELECT TO_CHAR(TO_DATE(FECHAENTRADA, 'MM/DD/YYYY'), 'WW') AS SEMANA, R.NHABITACION, COUNT(R.NHABITACION) AS CANTIDAD_HABITACION " +//
                  "FROM RESERVAS R "+//
                  "WHERE TO_CHAR(TO_DATE(FECHAENTRADA, 'MM/DD/YYYY'), 'WW')= :semana "+//
                  "GROUP BY TO_CHAR(TO_DATE(FECHAENTRADA, 'MM/DD/YYYY'), 'WW'), R.NHABITACION "+//
                  "ORDER BY COUNT(R.NHABITACION) DESC "+//
                  "FETCH FIRST 1 ROW ONLY", nativeQuery = true)
    Collection<RespuestaInformacionHabitacionesMasSolicitadas> darHabitacionesMasSolicitadas(@Param("semana") int id);




@Query(value="SELECT TO_CHAR(TO_DATE(FECHAENTRADA, 'MM/DD/YYYY'), 'WW') AS SEMANA, R.NHABITACION, COUNT(R.NHABITACION) AS CANTIDAD_HABITACION " +//
                  "FROM RESERVAS R "+//
                  "WHERE TO_CHAR(TO_DATE(FECHAENTRADA, 'MM/DD/YYYY'), 'WW')= :semana "+//
                  "GROUP BY TO_CHAR(TO_DATE(FECHAENTRADA, 'MM/DD/YYYY'), 'WW'), R.NHABITACION "+//
                  "ORDER BY COUNT(R.NHABITACION) ASC "+//
                  "FETCH FIRST 1 ROW ONLY", nativeQuery = true)
    Collection<RespuestaInformacionHabitacionesMenosSolicitadas> darHabitacionesMenosSolicitadas(@Param("semana") int id);
    

}