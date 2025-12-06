package Equipoo.Reservas.Controller;

import org.springframework.web.bind.annotation.*;

import Equipoo.Reservas.DTO.MesaDto;
import Equipoo.Reservas.Service.MesaService;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4000")
@RestController
@RequestMapping("/api/mesas")
public class MesaController {

    private final MesaService mesaService;

    public MesaController(MesaService mesaService) {
        this.mesaService = mesaService;
    }

    @GetMapping
    public List<MesaDto> getAllMesas() {
        return mesaService.getAllMesas();
    }

    @GetMapping("/{id}")
    public MesaDto getMesaById(@PathVariable Integer id) {
        return mesaService.getMesaById(id);
    }

    @PostMapping
    public MesaDto createMesa(@RequestBody MesaDto mesaDto) {
        return mesaService.createMesa(mesaDto);
    }

    @PutMapping("/{id}")
    public MesaDto updateMesa(@PathVariable Integer id, @RequestBody MesaDto mesaDto) {
        return mesaService.updateMesa(id, mesaDto);
    }

    @DeleteMapping("/{id}")
    public void deleteMesa(@PathVariable Integer id) {
        mesaService.deleteMesa(id);
    }
}