package Equipoo.Reservas.Service.Impl;

import Equipoo.Reservas.Client.TipoClient;
import Equipoo.Reservas.DTO.TipoDto;
import Equipoo.Reservas.Service.TipoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoServiceImpl implements TipoService {

    private final TipoClient tipoClient;

    public TipoServiceImpl(TipoClient tipoClient) {
        this.tipoClient = tipoClient;
    }

    @Override
    public List<TipoDto> getAllTipos() {
        return tipoClient.getAllTipos();
    }

    @Override
    public TipoDto getTipoById(Long id) {
        return tipoClient.getTipoById(id);
    }

    @Override
    public TipoDto createTipo(TipoDto tipoDto) {
        return tipoClient.createTipo(tipoDto);
    }

    @Override
    public TipoDto updateTipo(Long id, TipoDto tipoDto) {
        return tipoClient.updateTipo(id, tipoDto);
    }

    @Override
    public void deleteTipo(Long id) {
        tipoClient.deleteTipo(id);
    }
}
