# parcial-final-bd-eventos-congreso
Examen final de Bases de Datos – Aplicación CRUD JDBC + MySQL – CEA Eventos de Congreso.

CEA: Eventos de Congreso

Este repositorio contiene el proyecto correspondiente al examen final de la asignatura Bases de Datos, donde se integra una base de datos MySQL con una aplicación desarrollada en Java utilizando JDBC, sin uso de ORM ni herramientas automáticas.

 Contenido del repositorio
parcial-final-bd-eventos-congreso/
│
├── src/                         
├── lib/                         
├── nbproject/                    
├── build/                       
├── script/eventos_congreso.sql   
├── informe/Informe_Final.pdf     
├── capturas/                    
└── README.md                    

Tecnologías utilizadas

Java 17

MySQL 8.0

JDBC – mysql-connector-j-9.5.0.jar

NetBeans IDE 15+

Base de datos

La base de datos utilizada corresponde al CEA “Eventos de Congreso”.
El script SQL completo se encuentra en:

/script/eventos_congreso.sql

Este archivo contiene:

Creación de tablas

Llaves primarias y foráneas

Relaciones

Inserts iniciales
Conexión a MySQL

La clase ConexionBD.java establece la conexión mediante:

Connection conexion = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/eventos_congreso",
    "root",
    "tu_clave"
);

Operaciones CRUD

Implementadas en la clase CongresistaDAO.java:

INSERT – Registrar nuevo congresista

SELECT – Listar y buscar por ID

UPDATE – Actualizar datos

DELETE – Eliminar registros (controlado por integridad referencial)

Evidencias de funcionamiento se encuentran en /capturas/.

Consultas SQL desde Java

En la clase ConsultasApp.java se implementaron 5 consultas SQL:

Listar todos los congresistas

Contar registros

Buscar por país

Ordenados por apellido

Filtrar por institución

Video de sustentación

Enlace del video:
https://www.youtube.com/watch?v=LB751Ksbz6A

Autor

Antonio Luis De Ávila Pájaro
Estudiante de Ingeniería de Software – Universidad de Cartagena
Código: 7502420052
