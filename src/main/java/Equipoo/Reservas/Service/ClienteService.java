package Equipoo.Reservas.Service;

import java.util.List;
import Equipoo.Reservas.DTO.ClienteDto;

public interface ClienteService {
    List<ClienteDto> getAllClientes();
    ClienteDto getClienteById(Integer id);
    ClienteDto createCliente(ClienteDto clienteDto);
    ClienteDto updateCliente(Integer id, ClienteDto clienteDto);
    void deleteCliente(Integer id);
}
