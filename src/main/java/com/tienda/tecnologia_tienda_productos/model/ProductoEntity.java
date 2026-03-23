package com.tienda.tecnologia_tienda_productos.model;
import com.tienda.tecnologia_tienda_productos.model.ProductoEntity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/*
 Entidad que representa la tabla "productos" en la base de datos.
 Se encarga del mapeo entre la BD y la aplicación.
*/
@Entity
@Table(name = "productos")
public class ProductoEntity {

    /*
     Clave primaria del producto.
     Se genera automáticamente en la base de datos.
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     Nombre del producto.
     Campo obligatorio y con longitud máxima de 100 caracteres.
    */
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    /*
     Descripción del producto.
     Campo opcional con longitud máxima de 100 caracteres.
    */
    @Column(name = "descripcion", length = 100)
    private String descripcion;

    /*
     Precio del producto.
     Campo obligatorio.
     Se utiliza BigDecimal para evitar errores de precisión.
     precision = total de dígitos
     scale = cantidad de decimales
    */
    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    /*
     Stock disponible del producto.
     No puede ser nulo.
    */
    @Column(name = "stock", nullable = false)
    private Integer stock;

    /*
     Estado del producto.
     Valores esperados: ACTIVO o INACTIVO.
    */
    @Column(name = "estado", length = 20)
    private String estado;

    /*
     Fecha de creación del registro.
     No se actualiza después de ser creado.
    */
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;

    /*
     Método que se ejecuta antes de persistir en la base de datos.
     Se usa para asignar valores por defecto.
    */
    @PrePersist
    public void prePersist() {
        if (this.estado == null) {
            this.estado = "ACTIVO";
        }
        this.fechaCreacion = LocalDateTime.now();
    }

    /*
     Constructor vacío requerido por JPA.
    */
    public ProductoEntity() {}

    /*
     Constructor completo para uso opcional.
    */
    public ProductoEntity(Long id, String nombre, String descripcion, BigDecimal precio, Integer stock, String estado, LocalDateTime fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }

    public Long getId() {
        return id;
    }

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

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado)
    {
        this.estado = estado;
    }
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
}