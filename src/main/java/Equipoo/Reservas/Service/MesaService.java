package Equipoo.Reservas.Service;
import Equipoo.Reservas.DTO.*;
import java.util.List;

public interface MesaService {
	List<MesaDto> getAllMesas();
    MesaDto getMesaById(Integer id);
    MesaDto createMesa(MesaDto mesaDto);
    MesaDto updateMesa(Integer id, MesaDto mesaDto);
    void deleteMesa(Integer id);
}
