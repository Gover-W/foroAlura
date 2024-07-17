# Foro API Rest

Una aplicación API REST para gestionar tópicos en un foro, desarrollada con Java, Spring Boot y MySQL.

## Tecnologías Utilizadas

- **Java**: versión 17
- **Maven**: versión 4
- **Spring Boot**: versión 3
- **MySQL**: versión 8
- **IDE**: IntelliJ IDEA

## Configuración del Proyecto

Proyecto configurado con Spring Initializr con las siguientes dependencias:

- **Lombok**
- **Spring Web**
- **Spring Boot DevTools**
- **Spring Data JPA**
- **Flyway Migration**
- **MySQL Driver**
- **Validation**
- **Spring Security**

## Endpoints

### Tópicos

- **Registrar Tópico**
  - **URL**: `/topicos`
  - **Método**: `POST`
  - **Descripción**: Registra un nuevo tópico.
  - **Body**:
    ```json
    {
      "titulo": "string",
      "mensaje": "string",
      "autor": "string",
      "curso": "string"
    }
    ```

- **Mostrar Todos los Tópicos**
  - **URL**: `/topicos`
  - **Método**: `GET`
  - **Descripción**: Muestra todos los tópicos paginados.
  - **Params**:
    - `page`: número de página
    - `size`: tamaño de página (por defecto 5)

- **Mostrar Tópico por ID**
  - **URL**: `/topicos/{id}`
  - **Método**: `GET`
  - **Descripción**: Muestra un tópico por su ID.

- **Actualizar Tópico**
  - **URL**: `/topicos/{id}`
  - **Método**: `PUT`
  - **Descripción**: Actualiza un tópico existente.
  - **Body**:
    ```json
    {
      "titulo": "string",
      "mensaje": "string",
      "autor": "string",
      "curso": "string"
    }
    ```

- **Eliminar Tópico**
  - **URL**: `/topicos/{id}`
  - **Método**: `DELETE`
  - **Descripción**: Elimina un tópico existente.

### Autenticación

- **Autenticar Usuario**
  - **URL**: `/login`
  - **Método**: `POST`
  - **Descripción**: Autentica un usuario y devuelve un token JWT.
  - **Body**:
    ```json
    {
      "login": "string",
      "clave": "string"
    }
    ```

## Instalación y Configuración

1. **Clonar el repositorio**:
   ```sh
   git clone https://github.com/tu_usuario/foro-api.git
