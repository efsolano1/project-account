**MICROSERVICES ACCOUNTS.**
En este repositorio se encuentran dos microservicios para la gestión de una aplicación bancaria donde se utilizan las siguientes tecnologías: MySQL, Spring Boot, RabbitMQ y Docker. El microservicio de account-movements se encarga de gestionar cuentas y movimientos, y el microservicio de customer-person se encarga de gestionar los clientes, además se utiliza RabbitMQ para la comunicación entre los 2 microservicios.

**REQUISITOS PREVIOS A LA EJECUCIÓN.**

- [Docker](https://www.docker.com/).
- [Docker Compose](https://docs.docker.com/compose/).
- [Postman](https://www.postman.com/)

**INSTRUCCIONES.**
1. Clonar el repositorio.
   `git clone https://github.com/efsolano1/project-account.git`
2. Acceder a la carpeta del repositorio.
   `cd project-account`
3. Ejecutar archivo docker-compose.yml, con el siguiente comando:
  `docker-compose up -d`
