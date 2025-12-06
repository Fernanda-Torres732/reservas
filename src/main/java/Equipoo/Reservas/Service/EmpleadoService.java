package Equipoo.Reservas.Service;

import Equipoo.Reservas.DTO.*;
import Equipoo.Reservas.Entidades.Empleado;

import java.util.List;
import java.util.Optional;

public interface EmpleadoService {
    List<EmpleadoDto> getAllEmpleados();
    EmpleadoDto getEmpleadoById(Long id);
    EmpleadoDto createEmpleado(EmpleadoDto empleadoDto);
    EmpleadoDto updateEmpleado(Long id, EmpleadoDto empleadoDto);
    void deleteEmpleado(Long id);
   // Optional<Empleado> validarCredenciales(String nombre, String password);
}