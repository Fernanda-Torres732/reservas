package Equipoo.Reservas.Service.Impl;

import org.springframework.stereotype.Service;

import Equipoo.Reservas.Client.ClienteClient;
import Equipoo.Reservas.DTO.ClienteDto;
import Equipoo.Reservas.DTO.ReservarDto;
import Equipoo.Reservas.Entidades.Mesa;
import Equipoo.Reservas.Entidades.Reservar;
import Equipoo.Reservas.Mapeo.ReservarMapper;
import Equipoo.Reservas.Repository.MesaRepository;
import Equipoo.Reservas.Repository.ReservarRepository;
import Equipoo.Reservas.Service.ReservarService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservarServiceImpl implements ReservarService {

    private final ReservarRepository reservarRepository;
    private final MesaRepository mesaRepository;
    private final ClienteClient clienteClient;

    public ReservarServiceImpl(ReservarRepository reservarRepository,
                               MesaRepository mesaRepository,
                               ClienteClient clienteClient) {
        this.reservarRepository = reservarRepository;
        this.mesaRepository = mesaRepository;
        this.clienteClient = clienteClient;
    }

    @Override
    public List<ReservarDto> getAllReservas() {
        return reservarRepository.findAll()
                .stream()
                .map(ReservarMapper::mapToReservarDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReservarDto getReservaById(Long id) {
        Reservar reserva = reservarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada con id " + id));
        return ReservarMapper.mapToReservarDTO(reserva);
    }

    @Override
    public ReservarDto createReserva(ReservarDto reservarDto) {
        // Obtener cliente desde el microservicio Restaurante
        ClienteDto cliente = clienteClient.findById(reservarDto.getIdCliente());
        if (cliente == null) {
            throw new RuntimeException("El cliente no existe en Restaurante con id " + reservarDto.getIdCliente());
        }

        // Obtener mesa local
        Mesa mesa = mesaRepository.findById(reservarDto.getIdMesa())
                .orElseThrow(() -> new RuntimeException("Mesa no encontrada con id " + reservarDto.getIdMesa()));

        Reservar reserva = ReservarMapper.mapToReservar(reservarDto, cliente, mesa);
        Reservar saved = reservarRepository.save(reserva);
        return ReservarMapper.mapToReservarDTO(saved);
    }

    @Override
    public ReservarDto updateReserva(Long id, ReservarDto reservarDto) {
        Reservar reserva = reservarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada con id " + id));

        // Igual que en create, pero validamos cliente con el clienteClient
        ClienteDto cliente = clienteClient.findById(reservarDto.getIdCliente());
        if (cliente == null) {
            throw new RuntimeException("El cliente no existe en Restaurante con id " + reservarDto.getIdCliente());
        }

        Mesa mesa = mesaRepository.findById(reservarDto.getIdMesa())
                .orElseThrow(() -> new RuntimeException("Mesa no encontrada con id " + reservarDto.getIdMesa()));

        // Actualizar campos
        reserva.setFecha(reservarDto.getFecha());
        reserva.setHora(reservarDto.getHora());
        reserva.setIdCliente(reservarDto.getIdCliente()); 
        reserva.setMesa(mesa);

        Reservar updated = reservarRepository.save(reserva);
        return ReservarMapper.mapToReservarDTO(updated);
    }

    @Override
    public void deleteReserva(Long id) {
        if (!reservarRepository.existsById(id)) {
            throw new RuntimeException("Reserva no encontrada con id " + id);
        }
        reservarRepository.deleteById(id);
    }
    @Override
    public ReservarDto confirmarReserva(Long id) {
        Reservar reserva = reservarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));

        reserva.setEstatus(2);
        Reservar actualizada = reservarRepository.save(reserva);
        return ReservarMapper.mapToReservarDTO(actualizada);
    }

    @Override
    public void cancelarReserva(Long id) {
        Reservar reserva = reservarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));

        if (reserva.getEstatus() == 2) {
            throw new RuntimeException("No se puede cancelar una reserva confirmada");
        }

        reservarRepository.delete(reserva);
    }

}
