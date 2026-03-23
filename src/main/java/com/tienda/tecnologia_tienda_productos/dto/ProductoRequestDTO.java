package com.tienda.tecnologia_tienda_productos.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

/*
 DTO para recibir datos en las operaciones de creación y actualización.
 No expone campos internos como id, estado o fecha de creación.
*/
public class ProductoRequestDTO {

    /*
     Nombre del producto.
     No puede ser nulo ni vacío.
    */
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    /*
     Descripción del producto.
     Campo opcional.
    */
    private String descripcion;

    /*
     Precio del producto.
     Debe ser mayor a cero.
    */
    @Positive(message = "El precio debe ser mayor a 0")
    private BigDecimal precio;

    /*
     Stock del producto.
     No puede ser negativo.
    */
    @Min(value = 0, message = "El stock no puede ser negativo")
    private Integer stock;

    /*
     Constructor vacío.
    */
    public ProductoRequestDTO() {}

    /*
     Getters y Setters.
    */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}