package Equipoo.Reservas.Controller;
import org.springframework.web.bind.annotation.*;

import Equipoo.Reservas.DTO.ReservarDto;
import Equipoo.Reservas.Service.ReservarService;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4000")
@RestController
@RequestMapping("/api/reservas")
public class ReservarController {

    private final ReservarService reservarService;

    public ReservarController(ReservarService reservarService) {
        this.reservarService = reservarService;
    }

    @GetMapping
    public List<ReservarDto> getAllReservas() {
        return reservarService.getAllReservas();
    }

    @GetMapping("/{id}")
    public ReservarDto getReservaById(@PathVariable Long id) {
        return reservarService.getReservaById(id);
    }

    @PostMapping
    public ReservarDto createReserva(@RequestBody ReservarDto reservaDto) {
        return reservarService.createReserva(reservaDto);
    }

    @PutMapping("/{id}")
    public ReservarDto updateReserva(@PathVariable Long id, @RequestBody ReservarDto reservaDto) {
        return reservarService.updateReserva(id, reservaDto);
    }

    @DeleteMapping("/{id}")
    public void deleteReserva(@PathVariable Long id) {
        reservarService.deleteReserva(id);
    }
    @PutMapping("/{id}/confirmar")
    public ReservarDto confirmarReserva(@PathVariable Long id) {
        return reservarService.confirmarReserva(id);
    }

    @DeleteMapping("/{id}/cancelar")
    public void cancelarReserva(@PathVariable Long id) {
        reservarService.cancelarReserva(id);
    }

}