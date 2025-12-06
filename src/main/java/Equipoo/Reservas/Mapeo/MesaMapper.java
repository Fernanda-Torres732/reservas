package Equipoo.Reservas.Mapeo;

import Equipoo.Reservas.Entidades.Mesa;
import Equipoo.Reservas.DTO.MesaDto;

public class MesaMapper {

    public static MesaDto mapToMesaDTO(Mesa mesa) {
        if (mesa == null) return null;

        MesaDto dto = new MesaDto();
        dto.setIdMesa(mesa.getIdMesa());
        dto.setNumero(mesa.getNumero());
        dto.setCapacidad(mesa.getCapacidad());
        dto.setUbicacion(mesa.getUbicacion());

        return dto;
    }

    public static Mesa mapToMesa(MesaDto dto) {
        if (dto == null) return null;

        Mesa mesa = new Mesa();

        // ✔ Solo asignar ID si existe (para update)
        if (dto.getIdMesa() != null) {
            mesa.setIdMesa(dto.getIdMesa());
        }

        mesa.setNumero(dto.getNumero());
        mesa.setCapacidad(dto.getCapacidad());
        mesa.setUbicacion(dto.getUbicacion());

        return mesa;
    }
}
