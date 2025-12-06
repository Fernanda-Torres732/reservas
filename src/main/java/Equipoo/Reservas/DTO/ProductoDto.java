package Equipoo.Reservas.DTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDto {
    private Long idProducto;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Long idTipo; 
}