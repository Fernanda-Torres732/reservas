package Equipoo.Reservas.Service.Impl;
import org.springframework.stereotype.Service;

import Equipoo.Reservas.DTO.MesaDto;
import Equipoo.Reservas.Entidades.Mesa;
import Equipoo.Reservas.Mapeo.MesaMapper;
import Equipoo.Reservas.Repository.MesaRepository;
import Equipoo.Reservas.Service.MesaService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MesaServiceImpl implements MesaService {

    private final MesaRepository mesaRepository;

    public MesaServiceImpl(MesaRepository mesaRepository) {
        this.mesaRepository = mesaRepository;
    }

    @Override
    public List<MesaDto> getAllMesas() {
        return mesaRepository.findAll()
                .stream()
                .map(MesaMapper::mapToMesaDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MesaDto getMesaById(Integer id) {
        Mesa mesa = mesaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mesa no encontrada con id " + id));
        return MesaMapper.mapToMesaDTO(mesa);
    }

    @Override
    public MesaDto createMesa(MesaDto mesaDto) {
        Mesa mesa = MesaMapper.mapToMesa(mesaDto);
        Mesa saved = mesaRepository.save(mesa);
        return MesaMapper.mapToMesaDTO(saved);
    }

    @Override
    public MesaDto updateMesa(Integer id, MesaDto mesaDto) {
        Mesa mesa = mesaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mesa no encontrada con id " + id));

        mesa.setNumero(mesaDto.getNumero());
        mesa.setCapacidad(mesaDto.getCapacidad());
        mesa.setUbicacion(mesaDto .getUbicacion());

        Mesa updated = mesaRepository.save(mesa);
        return MesaMapper.mapToMesaDTO(updated);
    }

    @Override
    public void deleteMesa(Integer id) {
        if (!mesaRepository.existsById(id)) {
            throw new RuntimeException("Mesa no encontrada con id " + id);
        }
        mesaRepository.deleteById(id);
    }
}