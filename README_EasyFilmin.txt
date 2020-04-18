EASY FILMIN

1- mvn clean compile
2- execute db script in MySQL WorkBench
3- mvn datanucleus:schema-create //esquema sql
4- mvn jetty:run //levanta el servidor web
(5- mvn exec:java -Padmin // SOLO SI NO ESTÁN METIDOS Para introducir la info en los CSVs si no está hecho ya )
6- mvn exec:java -Pclient // ejecutamos main del client y nos sale la ventana de login 
