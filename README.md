# **Proyecto spring-boot-webSockets-demo1**
Recibe mensajes de los clientes y lo difunde para que lo reciban los clientes que se han subscrito.

Herramientas / Frameworks y componentes empleados:
--------------------------------------------------
- Spring boot 
- Git
- Gradle


Instrucciones para importar el proyecto en eclipse:
---------------------------------------------------

Adaptación del proyecto a nuestro entorno:
------------------------------------------
** Si desplegamos sobre Tomcat:**
En el fichero dradle.properties, asignar a la variable tomcatHome, la carpeta donde se pondrá el .war
  tomcatHome=C:\\AppPortables\\WebServers\\apache-tomcat-8.5.11\\webapps; por ejemplo

** Si lanzamos desde eclipse:**
Run As -> Java Aplication -> y Seleccionar Application - pac 
Esto lanzar� tomcat interno definido en eclipse

Para probar:
------------
[http://localhost:8080/spring-boot-websockets](http://)

Para cabiar de puerto, podemos hacerlo en el fichero /resources/application.yml
