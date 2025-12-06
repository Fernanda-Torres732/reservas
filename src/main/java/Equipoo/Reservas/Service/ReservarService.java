package Equipoo.Reservas.Service;
import Equipoo.Reservas.DTO.*;
import java.util.List;

public interface ReservarService {
	List<ReservarDto> getAllReservas();
    ReservarDto getReservaById(Long id);
    ReservarDto createReserva(ReservarDto reservaDto);
    ReservarDto updateReserva(Long id, ReservarDto reservaDto);
    void deleteReserva(Long id);
    ReservarDto confirmarReserva(Long id);
    void cancelarReserva(Long id);

}
