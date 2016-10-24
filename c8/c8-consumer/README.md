in order to run `Main.java` we need to deploy c8-service to a server.
(otherwise 
```
Connection refused: connect
Lookup failed for 'java:global/c8-service-1.0/BookEJB!c8.BookEJBRemote'
org.omg.CORBA.COMM_FAILURE: FINE: 00410001: Connection failure: socketType: IIOP_CLEAR_TEXT; hostname: localhost; port: 3700
...
```
etc.)
so, first we run payara server `./asadmin start-domain -v`
then, we deploy c8-service to payara `./asadmin deploy --force=true /path/to/target/c8-service-1.0.jar`