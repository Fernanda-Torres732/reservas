package Equipoo.Reservas.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    private long id;
    private String nombre;
    private String rol;
    private String tipo; 
    
}
