package Equipoo.Reservas.Controller;
import org.springframework.web.bind.annotation.*;
import Equipoo.Reservas.DTO.EmpleadoDto;

import Equipoo.Reservas.Service.EmpleadoService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4000")
@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;
   

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
   
    }
  
    @GetMapping
    public List<EmpleadoDto> getAllEmpleados() {
        return empleadoService.getAllEmpleados();
    }

    @GetMapping("/{id}")
    public EmpleadoDto getEmpleadoById(@PathVariable Long id) {
        return empleadoService.getEmpleadoById(id);
    }

    @PostMapping
    public EmpleadoDto createEmpleado(@RequestBody EmpleadoDto empleadoDto) {
        return empleadoService.createEmpleado(empleadoDto);
    }

    @PutMapping("/{id}")
    public EmpleadoDto updateEmpleado(@PathVariable Long id, @RequestBody EmpleadoDto empleadoDto) {
        return empleadoService.updateEmpleado(id, empleadoDto);
    }

    @DeleteMapping("/{id}")
    public void deleteEmpleado(@PathVariable Long id) {
        empleadoService.deleteEmpleado(id);
    }
   

}