package com.tienda.tecnologia_tienda_productos.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/*
 DTO utilizado para enviar información del producto al cliente.
 Incluye todos los campos relevantes de salida.
*/
public class ProductoResponseDTO {

    /*
     Identificador del producto.
    */
    private Long id;

    /*
     Nombre del producto.
    */
    private String nombre;

    /*
     Descripción del producto.
    */
    private String descripcion;

    /*
     Precio del producto.
    */
    private BigDecimal precio;

    /*
     Stock disponible.
    */
    private Integer stock;

    /*
     Estado del producto.
    */
    private String estado;

    /*
     Fecha de creación del registro.
    */
    private LocalDateTime fechaCreacion;

    /*
     Constructor vacío.
    */
    public ProductoResponseDTO() {}

    /*
     Constructor completo.
    */
    public ProductoResponseDTO(Long id, String nombre, String descripcion, BigDecimal precio, Integer stock, String estado, LocalDateTime fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public Integer getStock() {
        return stock;
    }

    public String getEstado() {
        return estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
}