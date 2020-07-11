

This a REST API Consumer application. 
* Note - skipthedishes api is not working instead  I have used a mock to return the same json response, although code is already in place and currently commented out which can uncommented and build to use the real api.
ConsumerController.java has more inputs on this.

### Tech

This application uses a number of open source projects:
* Java 8 
* Spring Boot 2.3.1
* Guava 22
* Gson 2.8.0
* Maven 3.6.2
* STS IDE
* Postman 

### Build and Running

Requires Java 8 and maven 3.x already installed in the machine

```sh
$ cd rest-consuming
$ mvn spring-boot:run
```
Above command does maven build followed by starts the application on port 8085

### Testing

Postman can be used to access the application 

GET Request
Sample URI - http://localhost:8085/cities/ON
Header - Accept - application/json

### JUnit Testing 
```sh
$ cd rest-consuming
$ mvn clean install
```
Builds and run the junit tests.