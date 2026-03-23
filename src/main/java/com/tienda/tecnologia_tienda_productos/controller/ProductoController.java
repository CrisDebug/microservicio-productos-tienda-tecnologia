package com.tienda.tecnologia_tienda_productos.controller;

import com.tienda.tecnologia_tienda_productos.dto.ProductoRequestDTO;
import com.tienda.tecnologia_tienda_productos.dto.ProductoResponseDTO;
import com.tienda.tecnologia_tienda_productos.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 Controlador REST para la gestión de productos.
 Expone los endpoints de la API.
*/
@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    /*
     Inyección por constructor
    */
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    /*
     GET /productos
     Obtiene todos los productos
    */
    @GetMapping
    public ResponseEntity<List<ProductoResponseDTO>> listar() {
        return ResponseEntity.ok(productoService.listar());
    }

    /*
     GET /productos/{id}
     Obtiene un producto por su ID
    */
    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(productoService.obtenerPorId(id));
    }

    /*
     POST /productos
     Crea un nuevo producto
    */
    @PostMapping
    public ResponseEntity<ProductoResponseDTO> crear(
            @Valid @RequestBody ProductoRequestDTO request) {

        ProductoResponseDTO nuevoProducto = productoService.crear(request);
        return ResponseEntity.ok(nuevoProducto);
    }

    /*
     PUT /productos/{id}
     Actualiza un producto existente
    */
    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody ProductoRequestDTO request) {

        return ResponseEntity.ok(productoService.actualizar(id, request));
    }

    /*
     DELETE /productos/{id}
     Elimina un producto
    */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        productoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}