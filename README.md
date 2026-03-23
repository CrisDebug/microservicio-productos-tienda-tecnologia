# Microservicio Productos - Tienda Tecnología

Este proyecto es un **microservicio de gestión de productos** para una tienda de tecnología, desarrollado en **Spring Boot** con arquitectura profesional, siguiendo buenas prácticas en capas, DTOs, validaciones y manejo de errores.

---

## 📦 Tecnologías

- Java 17
- Spring Boot 3
- Spring Data JPA
- Maven
- Oracle XE 21c
- Jakarta Validation
- Git / GitHub

---

## 🏗 Arquitectura

Se implementó **arquitectura por capas**:

- **Controller** → expone endpoints REST
- **Service** → contiene la lógica de negocio
- **Repository** → interacción con la base de datos
- **DTOs** → separación entre entidad y la API
- **Exception** → manejo global de errores
- **Soft delete** → los productos se eliminan lógicamente (estado `ACTIVO` / `INACTIVO`)

---

## 🔹 Modelo de Producto

| Campo          | Tipo        | Restricción                  |
|----------------|------------|------------------------------|
| id             | Long       | PK, autogenerado             |
| nombre         | String     | obligatorio                  |
| descripcion    | String     | opcional                     |
| precio         | double     | > 0                          |
| stock          | int        | >= 0                         |
| estado         | String     | ACTIVO / INACTIVO (soft delete) |
| fechaCreacion  | LocalDateTime | autogenerada               |

---

## 🌐 Endpoints

| Método | Endpoint               | Descripción                  |
|--------|-----------------------|------------------------------|
| GET    | `/productos`           | Listar todos los productos activos |
| GET    | `/productos/{id}`      | Obtener producto por ID      |
| POST   | `/productos`           | Crear un nuevo producto      |
| PUT    | `/productos/{id}`      | Actualizar producto (excepto estado) |
| DELETE | `/productos/{id}`      | Eliminar producto (soft delete) |

---

## 🔒 Validaciones

- `@NotBlank` → nombre
- `@Positive` → precio
- `@Min(0)` → stock

---

## ⚠️ Manejo de errores

Se implementó `@ControllerAdvice` con excepciones personalizadas:

- `ResourceNotFoundException` → 404 si no se encuentra un producto
- `MethodArgumentNotValidException` → errores de validación
- Respuestas limpias en JSON

---

## 💡 Buenas prácticas aplicadas

- DTOs para separar entidad y API
- Soft delete para mantener integridad
- Arquitectura en capas (Controller, Service, Repository)
- Validaciones de negocio y datos
- Manejo global de errores
- Código limpio y documentado

---

## 📌 Ejecución

1. Clonar el repositorio:

```bash
git clone https://github.com/CrisDebug/microservicio-productos-tienda-tecnologia.git