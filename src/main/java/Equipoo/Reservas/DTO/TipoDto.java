package Equipoo.Reservas.DTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoDto {
    private Long idTipo;
    private String nombre;
    private String descripcion;
}