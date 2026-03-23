package com.tienda.tecnologia_tienda_productos.service;


import com.tienda.tecnologia_tienda_productos.dto.ProductoRequestDTO;
import com.tienda.tecnologia_tienda_productos.dto.ProductoResponseDTO;
import com.tienda.tecnologia_tienda_productos.model.ProductoEntity;
import com.tienda.tecnologia_tienda_productos.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/*
 Servicio que contiene la lógica de negocio para productos.
 Se encarga de la comunicación entre Controller y Repository.
*/
@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    /*
     Inyección por constructor (buena práctica)
    */
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    /*
     Obtener todos los productos
    */
    public List<ProductoResponseDTO> listar() {
        return productoRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    /*
     Obtener producto por ID
    */
    public ProductoResponseDTO obtenerPorId(Long id) {
        ProductoEntity producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));

        return mapToResponse(producto);
    }

    /*
     Crear nuevo producto
    */
    public ProductoResponseDTO crear(ProductoRequestDTO request) {
        ProductoEntity producto = mapToEntity(request);
        ProductoEntity guardado = productoRepository.save(producto);
        return mapToResponse(guardado);
    }

    /*
     Actualizar producto existente
    */
    public ProductoResponseDTO actualizar(Long id, ProductoRequestDTO request) {

        ProductoEntity producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));

        producto.setNombre(request.getNombre());
        producto.setDescripcion(request.getDescripcion());
        producto.setPrecio(request.getPrecio());
        producto.setStock(request.getStock());

        ProductoEntity actualizado = productoRepository.save(producto);

        return mapToResponse(actualizado);
    }

    /*
     Eliminar producto
    */
    public void eliminar(Long id) {
    ProductoEntity producto = productoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));

    producto.setEstado("INACTIVO");
    productoRepository.save(producto);
}

    /*
     Conversión de Entity a ResponseDTO
    */
    private ProductoResponseDTO mapToResponse(ProductoEntity producto) {
        return new ProductoResponseDTO(
                producto.getId(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getStock(),
                producto.getEstado(),
                producto.getFechaCreacion()
        );
    }

    /*
     Conversión de RequestDTO a Entity
    */
    private ProductoEntity mapToEntity(ProductoRequestDTO request) {
        ProductoEntity producto = new ProductoEntity();
        producto.setNombre(request.getNombre());
        producto.setDescripcion(request.getDescripcion());
        producto.setPrecio(request.getPrecio());
        producto.setStock(request.getStock());
        return producto;
    }
}