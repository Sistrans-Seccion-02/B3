package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Empleado;
import uniandes.edu.co.proyecto.modelo.Usuario;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{
    @Query(value="SELECT * FROM empleados", nativeQuery = true)
    Collection<Empleado> darEmpleados();

    @Query(value = "SELECT * FROM empleados WHERE id= : id", nativeQuery= true)
    Usuario darEmpleadoID(@Param("id") Integer id);
   

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO empleados (nombre) VALUES (B3-Proyecto1_sequence.nextval, :nombre)", nativeQuery = true)
    void insertarEmpleado(@Param("nombre") String nombre, @Param("cargo")String cargo);
   
    @Modifying
    @Transactional
    @Query(value = "UPDATE empleados SET nombre=:nombre WHERE id=:id", nativeQuery = true)
    void actualizarEmpleado(@Param("id") int id, @Param("nombre") String nombre, @Param("cargo") String cargo);


    @Modifying
    @Transactional
    @Query(value="DELETE FROM empleados WHERE id=:id", nativeQuery = true)
    void eliminarEmpleado(@Param("id") Integer id);
    
}
