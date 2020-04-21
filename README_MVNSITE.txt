
Conforme se añadan herramientas iré actualizando este .txt. 
La idea detrás de maven site es tener toda la información del proyecto centralizada (documentación, tests, dependencias, plugins, ...)

1-mvn clean compile

2-mvn test

3-mvn site

(mvn site os tardará bastante en ejecutar por primera vez)

CÓMO ENTRAR AL MVN SITE CREADO
Cuando acabe de ejecutar se generará en target/site un archivo .html que se llama index.
Este archivo lleva al .html de nuestro proyecto, donde está toda la información.
A la izquierda está el menú sobre el que se puede navegar, lo que más nos interesa es el desplegable "Project Reports"

Podeís ver enlaces a Javadoc, CheckStyle, JDepend, Jacoco, ...
(en el pom.xml se pueden añadir más, se metería el plugin deseado dentro de los tags <reporting></reporting>.

Ahora pondré secciones para los que sé como funcionan e iré actualizando conforme vayamos implementando:

JAVADOC:
	-Sale la documentación que hay por package en cada clase. 
	-IMPORTANTE: Si haceis anotaciones de javadoc para comentar una clase no dejeis la descripcion de cosas como @param o @return vacía, dara un error al realizar mvn site

JACOCO:
	-Representa el porcentaje de líneas de código que están "probadas" por un test.
	-Va por paquetes