package Equipoo.Reservas.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import Equipoo.Reservas.DTO.LoginRequest;
import Equipoo.Reservas.DTO.LoginResponse;
import Equipoo.Reservas.Client.ClienteClient;
import Equipoo.Reservas.Client.ClienteClient.ClienteDto;
import Equipoo.Reservas.Repository.EmpleadoRepository;
import Equipoo.Reservas.Entidades.Empleado;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private ClienteClient clienteClient;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {

        String tipo = (req.getTipo() != null) ? req.getTipo().toUpperCase() : "CLIENTE";

        String usuario = req.getUsuario();
        String password = req.getPassword();

        try {
            if ("CLIENTE".equals(tipo)) {

                ClienteDto in = new ClienteDto();
                in.setNombreCliente(usuario);
                in.setPassword(password);

                ClienteDto cliente = clienteClient.loginCliente(in);

                if (cliente != null && cliente.getId() != null) {
                    return ResponseEntity.ok(new LoginResponse(
                        cliente.getId(),
                        cliente.getNombreCliente(),
                        cliente.getRol() == null ? "CLIENTE" : cliente.getRol(),
                        "CLIENTE"
                    ));
                }

                return ResponseEntity.status(401).body("Credenciales inválidas (cliente)");
            }
            else {

                Optional<Empleado> opt = empleadoRepository.findByNombre(usuario);

                if (opt.isPresent()) {
                    Empleado emp = opt.get();

                    if (emp.getPassword().equals(password)) {
                        return ResponseEntity.ok(new LoginResponse(
                            emp.getIdEmpleado(),
                            emp.getNombre(),
                            emp.getPuesto(),
                            "EMPLEADO"
                        ));
                    }
                    return ResponseEntity.status(401).body("Credenciales inválidas (empleado)");
                }

                return ResponseEntity.status(404).body("Empleado no encontrado");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(500).body("Error en autenticación: " + ex.getMessage());
        }
    }
}
 