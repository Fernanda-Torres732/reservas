package Equipoo.Reservas.Client;

import Equipoo.Reservas.DTO.ProductoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "fondita", path = "/api/producto") 
public interface ProductoClient {

    @GetMapping
    List<ProductoDto> getAllProductos();

    @GetMapping("/{id}")
    ProductoDto getProductoById(@PathVariable("id") Long id);

    @PostMapping
    ProductoDto createProducto(@RequestBody ProductoDto productoDto);

    @PutMapping("/{id}")
    ProductoDto updateProducto(@PathVariable("id") Long id, @RequestBody ProductoDto productoDto);

    @DeleteMapping("/{id}")
    void deleteProducto(@PathVariable("id") Long id);
}
