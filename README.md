# Sistema para emitir Facturas
Este repositorio albergara la parte del backend para un sistema de facturas.
# Backend
Esta repositorio fue creado para el ejercio de la empresa Alquimiasoft, el cuál es una 
pequeña implememtación de una API para el consumo de clientes, pero se seguira mejorando
para hacerlo un pequeño sistema de facturación para fortalecer el portfolio.
## Herramientas necesarias
- JDK 17 u OpenJDK 17 en adelante.
- PostgreSQL 12 en adelante en este caso se ha usuado la version 15.3 https://www.postgresql.org/download/
- Editor de código(Para este proyecto se uso IntelliJ IDEA)

### Configuración del proyecto
La configuración delproyecto se la realizo en el sitio web de [Spring Initializr](https://start.spring.io/)
en donnde se realizo la siguiente configuración.
> `Projecto`-`Maven`

> `Lenguaje`-`Java` 

> `Versión Spring Boot`-`3.1.2`

> `Empaquetado`-`Jar`

> `Java Versión`-`17` 
 
#### Dependencias del Proyecto
```
<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<!-- https://mvnrepository.com/artifact/junit/junit -->
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.13.2</version>
			<scope>test</scope>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.mockito/mockito-core -->
		<dependency>
			<groupId>org.mockito</groupId>
			<artifactId>mockito-core</artifactId>
			<version>5.4.0</version>
			<scope>test</scope>
		</dependency>
	</dependencies>
```
#### Estructura
```json
src
│   └── main
│       ├── java
│       │   └── com
│       │       └── alquimiasoft
│       │           └── serviciofactura
|       |               └── controller
|       |               └── dto
|       |               └── entity
|       |               └── repository
|       |               └── service
│       │               └── ServicioFacturaApplication.java
│       └── resources
│           ├── static
│           ├── templates
│           └── application.properties
│           └── import.sql
│   └── test
│       ├── java
│       │   └── com
│       │       └── alquimiasoft
│       │           └── serviciofactura
│       │               └── respository
│       │               └── ServicioFacturaApplicationTests.java
└── pom.xml
```
En el archivo `applications.properties` esta la configuracion del 
proyecto Spring Boot, la siguiente línea especifica el puerto
donde se deplegara la aplicación.
```
# Puerto de despliegue local
server.port = 8080
```
#### Configuración de la Base de Datos
Para la base lo único que se hizo fue crear  una nueva Base de Datos
en PostreSQL, la creación de tablas y relaciones se la realizo mediante
JPA en Spring Boot, para que el proyecto se pueda conectar a la base de
datos PostgreSQL se tiene que especificar el **puerto**, 
**nombre de la bd**, **usuario** y el **password** 
en el archivo `applications.properties`. Donde dice `reemplazar` se tiene que
poner la configuración de su bd, el resto son anotaciones que nos
permiten crear la base y ver las consultas SQL.
```
# Configuración para la bd en PostgreSQL
# Puerto y nombre de la bd
spring.datasource.url=jdbc:postgresql://localhost:reemplazar/reemplazar
spring.datasource.username=reemplazar # Usuario de la bd
spring.datasource.password=reemplazar # Password de la bd

spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=create
spring.datasource.initialization-mode=always

# Mostrar las consultas SQL
spring.jpa.properties.hibernate.format_sql=true

```
### Docker
TD -> Contenerizar la aplicacion

### Despliegue
TD -> Realizar un despliegue de la aplicacion

## APIS
La documentación del uso de cada API generada en los controladores, 
se puede encontrar en la siguiente dirección.

https://documenter.getpostman.com/view/7970730/2s9XxtzbLe
# Frontend
TD -> Hacer el front con Angular
****