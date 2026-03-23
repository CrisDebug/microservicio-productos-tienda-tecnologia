package com.tienda.tecnologia_tienda_productos.repository;

import com.tienda.tecnologia_tienda_productos.model.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 Repositorio para la entidad Producto.
 
 Extiende JpaRepository para obtener automáticamente:
 - save()
 - findAll()
 - findById()
 - deleteById()
 - entre otros
*/
@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {

    /*
     Método personalizado para obtener productos por estado.
     Ejemplo: ACTIVO o INACTIVO
    */
    List<ProductoEntity> findByEstado(String estado);
}