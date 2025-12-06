package Equipoo.Reservas.DTO;

import lombok.Data;

@Data
public class LoginRequest {
    private String usuario;
    private String password;
    private String tipo;
}
