package Equipoo.Reservas.Service;
import Equipoo.Reservas.DTO.*;
import java.util.List;

public interface ProductoService {
	List<ProductoDto> getAllProductos();
    ProductoDto getProductoById(Long id);
    ProductoDto createProducto(ProductoDto productoDto);
    ProductoDto updateProducto(Long id, ProductoDto productoDto);
    void deleteProducto(Long id);
}
