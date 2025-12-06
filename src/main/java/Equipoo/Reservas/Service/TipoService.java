package Equipoo.Reservas.Service;
import Equipoo.Reservas.DTO.*;
import java.util.List;

public interface TipoService {
	List<TipoDto> getAllTipos();
    TipoDto getTipoById(Long id);
    TipoDto createTipo(TipoDto tipoDto);
    TipoDto updateTipo(Long id, TipoDto tipoDto);
    void deleteTipo(Long id);
}
