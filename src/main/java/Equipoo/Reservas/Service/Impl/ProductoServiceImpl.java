package Equipoo.Reservas.Service.Impl;

import Equipoo.Reservas.Client.ProductoClient;
import Equipoo.Reservas.DTO.ProductoDto;
import Equipoo.Reservas.Service.ProductoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoClient productoClient;

    public ProductoServiceImpl(ProductoClient productoClient) {
        this.productoClient = productoClient;
    }

    @Override
    public List<ProductoDto> getAllProductos() {
        return productoClient.getAllProductos();
    }

    @Override
    public ProductoDto getProductoById(Long id) {
        return productoClient.getProductoById(id);
    }

    @Override
    public ProductoDto createProducto(ProductoDto productoDto) {
        return productoClient.createProducto(productoDto);
    }

    @Override
    public ProductoDto updateProducto(Long id, ProductoDto productoDto) {
        return productoClient.updateProducto(id, productoDto);
    }

    @Override
    public void deleteProducto(Long id) {
        productoClient.deleteProducto(id);
    }
}
