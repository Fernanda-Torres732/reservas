package Equipoo.Reservas.Mapeo;

import Equipoo.Reservas.Entidades.Reservar;
import Equipoo.Reservas.Entidades.Mesa;
import Equipoo.Reservas.DTO.ClienteDto;
import Equipoo.Reservas.DTO.ReservarDto;

public class ReservarMapper {

    public static ReservarDto mapToReservarDTO(Reservar reserva) {
        if (reserva == null) return null;
        ReservarDto dto = new ReservarDto();
        dto.setIdReserva(reserva.getIdReserva());
        dto.setFecha(reserva.getFecha());
        dto.setHora(reserva.getHora());
        dto.setIdCliente(reserva.getIdCliente()); 
        dto.setIdMesa(reserva.getMesa() != null ? reserva.getMesa().getIdMesa() : null);
        dto.setEstatus(reserva.getEstatus());
        return dto;
    }

    public static Reservar mapToReservar(ReservarDto dto, ClienteDto cliente, Mesa mesa) {
        if (dto == null) return null;
        Reservar reserva = new Reservar();
        reserva.setIdReserva(dto.getIdReserva());
        reserva.setFecha(dto.getFecha());
        reserva.setHora(dto.getHora());
        reserva.setIdCliente(dto.getIdCliente()); 
        reserva.setMesa(mesa);
        reserva.setEstatus(dto.getEstatus());
        return reserva;
    }
}
