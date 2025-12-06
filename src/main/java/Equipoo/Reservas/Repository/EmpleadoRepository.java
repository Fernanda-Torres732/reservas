package Equipoo.Reservas.Repository;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import Equipoo.Reservas.Entidades.*;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{
	Optional<Empleado> findByNombre(String nombre);
}
