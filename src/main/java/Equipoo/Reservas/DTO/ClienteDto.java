package Equipoo.Reservas.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClienteDto {
    @JsonAlias({ "id", "idCliente" })
    private Integer id;
    @JsonAlias({ "nombre", "nombreCliente" })
    private String nombre;
    @JsonAlias({ "telefono", "telefonoCliente" })
    private String telefono;
    @JsonAlias({ "correo", "correoCliente", "email" })
    private String correo;
    @JsonAlias({ "password", "password", "password" })
    private String password;
    @JsonAlias({ "rol", "rol", "rol" })
    private String rol;
    
    // getters y setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
    
}
