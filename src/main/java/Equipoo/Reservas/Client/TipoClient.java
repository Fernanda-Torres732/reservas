package Equipoo.Reservas.Client;

import Equipoo.Reservas.DTO.TipoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "fondita", path = "/api/tipo")
public interface TipoClient {

    @GetMapping
    List<TipoDto> getAllTipos();

    @GetMapping("/{id}")
    TipoDto getTipoById(@PathVariable("id") Long id);

    @PostMapping
    TipoDto createTipo(@RequestBody TipoDto tipoDto);

    @PutMapping("/{id}")
    TipoDto updateTipo(@PathVariable("id") Long id, @RequestBody TipoDto tipoDto);

    @DeleteMapping("/{id}")
    void deleteTipo(@PathVariable("id") Long id);
}
