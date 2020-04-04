/* PEQUEÑA EXPLICACIÓN de HTTP y REST (clases ejemplo ExampleClient y Server)
 *  
 * Antes de empezar: las llamadas a los métodos remotos son mediante WebTargets e InvocationBuilders, para
 * que os vaya sonando.
 * 
 * Básicamente se fija una dirección web "http://<host>:<port>/rest" en la que se aloja el servidor web
 * esta dirección viene descrita en el "web.xml" del proyecto.
 * 
 * Una vez nos encontramos apuntando a esa dirección. Usamos un webTarget.path(<path>) para situarnos en los 
 * métodos que queremos usar. Estos métodos estarán indicados previamente con directivas "@Path()", "@POST" en
 * el lado del servidor.
 * 
 * Por lo que, para acceder por ejemplo a un método definido en un server con path = "server" y path del método = "/register"
 * tenemos que asignar el path con: webTarget.path("server/register") al webTarget con el que llamaremos al método 
 * 
 * Luego nos encargamos de llamar a ese método con el webTarget creado en el paso anterior mediante un invocationBuilder 
 * 1 con un request para ver que todo va bien
 * 2 con un post/get/... dependiendo si el cliente manda o recibe información
 *   
 *   
 * Por último: ejecutando desde maven (véase instrucciones de maven de Marcos)
 * Tal y como está descrito en el pom.xml, tras levantar el server con "mvn jetty:run", ejecutamos clases de java
 * ya sea a través de la mainClass o de perfiles.
 * En este caso, la clase (y por tanto el main que contiene) ExampleClient se ejecuta con el perfil "client" 
 * mediante "mvn exec:java -Pclient"  
 * 
 *   
 * More info: diapos de IntroduccionREST en ALUD 
 */