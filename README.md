**MICROSERVICES ACCOUNTS.**  
En este repositorio se encuentran dos microservicios para la gestión de una aplicación bancaria donde se utilizan las siguientes tecnologías: MySQL, Spring Boot, RabbitMQ y Docker. El microservicio de account-movements se encarga de gestionar cuentas y movimientos, y el microservicio de customer-person se encarga de gestionar los clientes, además se utiliza RabbitMQ para la comunicación entre los 2 microservicios.

**REQUISITOS PREVIOS A LA EJECUCIÓN.**

- [Docker](https://www.docker.com/).
- [Docker Compose](https://docs.docker.com/compose/).
- [Postman](https://www.postman.com/)

**INSTRUCCIONES.**
1. Clonar el repositorio.
   ```
   git clone https://github.com/efsolano1/project-account.git
   ```
3. Acceder a la carpeta del repositorio.
   ```
   cd project-account
   ```
5. Ejecutar archivo docker-compose.yml, con el siguiente comando:
  ```docker-compose up -d```
   Puede verificar que se han creado los contenedores, deberá verificar algo como en la imagen.
   ```
   ✔ Network microservices-project_app-network                    Created                                                                                                                                       0.3s
   ✔ Container microservices-project-mysql-1                      Started                                                                                                                                       3.0s
   ✔ Container microservices-project-customer-person-service-1    Started                                                                                                                                       1.3s
   ✔ Container microservices-project-account-movements-service-1  Started   
   ```
6. Para verificar que los contenedores están corriendo, ejecute el siguiente comando
      ```docker ps```
   La salida debería ser similar a: 

```
CONTAINER ID   IMAGE                       COMMAND                  CREATED              STATUS              PORTS                               NAMES
8a1ba0645cbd   account-movements-service   "java -jar app.jar"      About a minute ago   Up About a minute   0.0.0.0:8081->8081/tcp              microservices-project-account-movements-service-1
7fe19289bc61   customer-person-service     "java -jar app.jar"      About a minute ago   Up About a minute   0.0.0.0:8082->8082/tcp              microservices-project-customer-person-service-1
5782d11a841f   mysql:8.0                   "docker-entrypoint.s…"   About a minute ago   Up About a minute   0.0.0.0:3306->3306/tcp, 33060/tcp   microservices-project-mysql-1
```
5. Tomar en cuenta los puertos usados por cada contenedor para levantar los microservicios:  
   **3600:** Contenedor para MySQL.  
   **8081:** Microservicio Cuentas - Movimientos.  
   **8082:** Microservicio Cliente - Persona.  
6. Proceder a ejecutar las operaciones desde postman, pero primero debe cargar el .json [PROJECT_ACCOUNT.postman_collection.json](https://github.com/efsolano1/project-account/blob/master/PROJECT_ACCOUNT.postman_collection.json),  el cual ya contiene estas operaciones `(GET,POST,PUT y DELETE)` , y por medio del cual puede probar los endpoints.  
7. Si quiere detener y eliminar los contenedores ejecute el siguiente comando.  
    ```
   docker-compose down
    ```
