package Equipoo.Reservas.Mapeo;
import Equipoo.Reservas.Entidades.Empleado;
import Equipoo.Reservas.DTO.EmpleadoDto;
public class EmpleadoMapper {

    public static EmpleadoDto mapToEmpleadoDTO(Empleado empleado) {
        if (empleado == null) return null;
        EmpleadoDto dto = new EmpleadoDto();
        dto.setIdEmpleado(empleado.getIdEmpleado());
        dto.setNombre(empleado.getNombre());
        dto.setPuesto(empleado.getPuesto());
        return dto;
    }

    public static Empleado mapToEmpleado(EmpleadoDto dto) {
        if (dto == null) return null;
        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(dto.getIdEmpleado());
        empleado.setNombre(dto.getNombre());
        empleado.setPuesto(dto.getPuesto());
        return empleado;
    }
}
