# **MICROSERVICIOS APLICACION BANCARIA**
Este repositorio contiene dos microservicios diseñados para la gestión de una aplicación bancaria, implementados con Spring Boot y utilizando tecnologías como MySQL, RabbitMQ y Docker.

### **Microservicios**
- **account-movements:** Gestiona las cuentas bancarias y los movimientos asociados.
- **customer-person:** Administra la información de los clientes.

### **Comunicación entre Microservicios.**
La comunicación entre los microservicios se realiza de manera asíncrona mediante RabbitMQ, asegurando una integración eficiente y escalable.

### **Tecnologías utilizadas.**
- **Spring Boot:** Para el desarrollo de los microservicios.
- **MySQL:** Como base de datos relacional para la persistencia de datos.
- **RabbitMQ:** Para la mensajería y comunicación entre los microservicios.
- **Docker:** Para la contenedorización y despliegue de los servicios.

### **REQUISITOS PREVIOS A LA EJECUCIÓN.**

- [Docker](https://www.docker.com/).
- [Docker Compose](https://docs.docker.com/compose/).
- [Postman](https://www.postman.com/)

### **INSTRUCCIONES.**
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
   ✔ Network microservices-project_app-network                    Created                                                                                                                                       
   ✔ Container microservices-project-mysql-1                      Started                                                                                                                                      
   ✔ Container microservices-project-customer-person-service-1    Started        
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
