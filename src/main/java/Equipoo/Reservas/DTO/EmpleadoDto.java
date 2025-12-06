package Equipoo.Reservas.DTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoDto {
    private Long idEmpleado;
    private String nombre;
    private String puesto;
   	private String password;
   	
}