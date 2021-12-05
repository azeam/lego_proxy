### Netty proxy with basic round robin load balancer

- Start `mongod`
- Start two instances of the Spring API on ports 8080 and 8081
`cd lego_spring`
`mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8080`  
`mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8081`  
- Start the netty proxy `cd ../lego_proxy && mvn clean compile exec:java`

Requests can be sent to `http://localhost:6000/legos` and `http://localhost:6000/legos?name=Searchstring`