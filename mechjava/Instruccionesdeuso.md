# Instrucciones de uso - Mechjava

## Requisitos previos

- Java 17 o superior
- Maven
- Docker Desktop (opcional)
- MongoDB (local o Atlas)

## Instalación y configuración

1. Clona el repositorio y accede a la carpeta del proyecto.
2. Compila el proyecto:
   ```
   mvn clean install
   ```
3. Configura las propiedades necesarias en `src/main/resources/application.properties`:
   ```
   app.jwt.secret=TU_CLAVE_SECRETA
   app.jwt.expiration-minutes=60
   spring.data.mongodb.uri=TU_URI_MONGODB
   ```

## Ejecución

Para iniciar la aplicación localmente:
```
mvn spring-boot:run
```
La aplicación estará disponible en `http://localhost:8080`.

## Endpoints principales

### Autenticación

- **POST /auth/register**
  - Registra un nuevo usuario.
  - Body:
    ```json
    {
      "username": "usuario",
      "password": "contraseña"
    }
    ```
  - Respuesta: Token JWT y datos del usuario.

- **POST /auth/login**
  - Inicia sesión y devuelve un token JWT.
  - Body:
    ```json
    {
      "username": "usuario",
      "password": "contraseña"
    }
    ```
  - Respuesta: Token JWT.

### Libros

- **GET /libro**
  - Obtiene la lista de libros.
  - Respuesta:
    ```json
    [
      {
        "id": "...",
        "titulo": "...",
        "autor": "...",
        "editorial": "...",
        "anio": 2020
      }
    ]
    ```

- **POST /libro**
  - Crea un nuevo libro.
  - Body:
    ```json
    {
      "titulo": "...",
      "autor": "...",
      "editorial": "...",
      "anio": 2020
    }
    ```
  - Respuesta: Libro creado.

- **GET /libro/{id}**
  - Obtiene los detalles de un libro por ID.
  - Respuesta: Datos del libro.

- **PUT /libro/{id}**
  - Actualiza los datos de un libro.
  - Body: Igual al POST.
  - Respuesta: Libro actualizado.

- **DELETE /libro/{id}**
  - Elimina un libro por ID.
  - Respuesta: Confirmación de borrado.

### Editoriales

- **GET /editorial**
  - Lista todas las editoriales.

- **POST /editorial**
  - Crea una nueva editorial.

### CPU (Procesamiento)

- **POST /cpu**
  - Ejecuta una tarea de procesamiento.
  - Body:
    ```json
    {
      "n": 1000,
      "slow": false,
      "repetitions": 10
    }
    ```
  - Respuesta:
    ```json
    {
      "result": 123456,
      "elapsedMillis": 50,
      "slow": false,
      "repetitions": 10
    }
    ```

## Pruebas

Para ejecutar los tests:
```
mvn test
```

## Despliegue con Docker

1. Construye la imagen:
   ```
   docker build -t mechjava .
   ```
2. Ejecuta el contenedor:
   ```
   docker run -p 8080:8080 mechjava
   ```

## Notas

- Asegúrate de configurar correctamente las propiedades JWT y MongoDB.
- Si usas Docker, verifica que Docker Desktop esté corriendo.
- Para dudas técnicas, revisa la documentación interna o contacta al equipo de desarrollo.

