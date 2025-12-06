package Equipoo.Reservas.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@FeignClient(name = "restaurante", path = "/api/cliente")
public interface ClienteClient {

    @GetMapping
    List<Equipoo.Reservas.DTO.ClienteDto> findAll();

    @GetMapping("/{id}")
    Equipoo.Reservas.DTO.ClienteDto findById(@PathVariable("id") Integer id);

    @PostMapping
    Equipoo.Reservas.DTO.ClienteDto createCliente(@RequestBody Equipoo.Reservas.DTO.ClienteDto clienteDto);

    @PutMapping("/{id}/actualizar")
    Equipoo.Reservas.DTO.ClienteDto updateCliente(@PathVariable("id") Integer id, @RequestBody Equipoo.Reservas.DTO.ClienteDto clienteDto);

    @DeleteMapping("/{id}/desactivar")
    void deleteCliente(@PathVariable("id") Integer id);

    // llama al endpoint que definiste en restaurante: POST /api/cliente/login
    @PostMapping("/login")
    ClienteDto loginCliente(@RequestBody ClienteDto loginDto);

    // opcionales: si tienes endpoints de búsqueda en restaurante, ajusta las rutas
    @GetMapping("/buscarPorNombre")
    ClienteDto findByNombre(@RequestParam("nombre") String nombre);

    @GetMapping("/buscarPorCorreo")
    ClienteDto findByCorreo(@RequestParam("correo") String correo);

    // DTO interno para Feign
    @JsonIgnoreProperties(ignoreUnknown = true)
    class ClienteDto {
        @JsonAlias({ "id", "idCliente" })
        private Integer id;
        private String nombreCliente;
        private String telefonoCliente;
        private String correoCliente;
        private String password;
        private String rol;
        // getters y setters...
        public Integer getId(){return id;} public void setId(Integer id){this.id=id;}
        public String getNombreCliente(){return nombreCliente;} public void setNombreCliente(String n){this.nombreCliente=n;}
        public String getPassword(){return password;} public void setPassword(String p){this.password=p;}
        public String getCorreoCliente(){return correoCliente;} public void setCorreoCliente(String c){this.correoCliente=c;}
        public String getRol(){return rol;} public void setRol(String r){this.rol=r;}
        public String getTelefonoCliente(){return telefonoCliente;} public void setTelefonoCliente(String t){this.telefonoCliente=t;}
    }
}
