package Equipoo.Reservas.DTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class ReservarDto {
    private Long idReserva;
    private LocalDate fecha;
    private LocalTime hora;
    private Integer idCliente; 
    private Integer idMesa;   
    private int estatus;
}
