package Equipoo.Reservas.Service.Impl;
import org.springframework.stereotype.Service;
import Equipoo.Reservas.DTO.*;
import Equipoo.Reservas.Entidades.Empleado;
import Equipoo.Reservas.Mapeo.EmpleadoMapper;
import Equipoo.Reservas.Repository.*;
import Equipoo.Reservas.Service.EmpleadoService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	private final EmpleadoRepository empleadoRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public List<EmpleadoDto> getAllEmpleados() {
        return empleadoRepository.findAll()
                .stream()
                .map(EmpleadoMapper::mapToEmpleadoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmpleadoDto getEmpleadoById(Long id) {
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado con id " + id));
        return EmpleadoMapper.mapToEmpleadoDTO(empleado);
    }

    @Override
    public EmpleadoDto createEmpleado(EmpleadoDto empleadoDto) {
        Empleado empleado = EmpleadoMapper.mapToEmpleado(empleadoDto);
        // Encriptar contraseña antes de guardar
        if (empleado.getPassword() != null && !empleado.getPassword().isBlank()) {
            //empleado.setPassword(encoder.encode(empleado.getPassword()));
        }
        Empleado saved = empleadoRepository.save(empleado);
        return EmpleadoMapper.mapToEmpleadoDTO(saved);
    }

    @Override
    public EmpleadoDto updateEmpleado(Long id, EmpleadoDto empleadoDto) {
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado con id " + id));

        empleado.setNombre(empleadoDto.getNombre());
        empleado.setPuesto(empleadoDto.getPuesto());
        if (empleadoDto.getPassword() != null && !empleadoDto.getPassword().isBlank()) {
            empleado.setPassword(encoder.encode(empleadoDto.getPassword()));
        }

        Empleado updated = empleadoRepository.save(empleado);
        return EmpleadoMapper.mapToEmpleadoDTO(updated);
    }

    @Override
    public void deleteEmpleado(Long id) {
        if (!empleadoRepository.existsById(id)) {
            throw new RuntimeException("Empleado no encontrado con id " + id);
        }
        empleadoRepository.deleteById(id);
    }
    /*
    @Override
    public Optional<Empleado> validarCredenciales(String nombre, String password) {
        return empleadoRepository.findByNombre(nombre)
                .filter(emp -> encoder.matches(password, emp.getPassword()));
    }
    */
}