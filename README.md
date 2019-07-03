This service was requested as a codechallenge and has been build with Spring-Boot and Maven.

To build this service simply checkout the repository and build the project with "mvn install".
This will create a target folder with an self executable jar inside. To run the server simply type from the project directory
"java -Dstorage.file.path=<path to your images> -jar target/codechallengeserver-1.0-SNAPSHOT.jar"

Now the server should start and you will be able to request images by requesting "http://localhost:8080/generate-image" with the parameter requested from the challenge sheet. To make it a bit more easy to interact with the the service it has in integrated swagger documentation which you could reach by "http://localhost:8080/swagger-ui.html

