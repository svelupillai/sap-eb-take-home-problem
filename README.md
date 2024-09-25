# SAP Take Home Problem : The RESTful solution


## Scope
This project's aim is to expose a way for an end user to filter trails by at least 2 parameters of the developer's choice. 
Thus, this project exposes a rest API meant to accept a number of parameters and return the appropriate trails. 


## Technology
The following points summarize the technical decisions made in this project:
1. It is a spring boot restful api, the project is built with maven and Java 17. 
2. The csv is parsed and inserted into a H2 embedded database - I decided against having a separated sql process for the purposes of the assignment but in a real life production scenario depending on how often the database is queried and how popular the end point is we would want to have a dedicated sql server that is likely horizontally scaled.
3. Since we are using spring features for db initialization - it ensures that upon startup the database is populated from the csv file once.
4. I have used the lombok logger (annotated with Slf4j) to log any important information and errors for easy debugging. 
5. Proper models - 1 for repository level and 1 for response level - have been used, this has data sensitivity and extension in mind as in the future we may have some columns in the db that we want to exclude in the responses and we would simply update the appropriate response model to omit it and any changes with mapping can happen in the Mapper. 
6. Junit and Assertj were used for unit tests and Wiremock was used for integration tests for the api. 
7. Added an integration profile and populated the h2 db with a few entries (2) so the integration testing of the api can be properly tested. 
8. The api also accepts pageable params (page, size) for efficiency and leaving it open for uses by other services as they wish.  


## Prerequisites
- Java 17
- Maven
- Ensure IDE has Lombok enabled for compilation 


## How to run this app?

### Build

Use `mvn clean install` to build 

### Run

Use `mvn spring-boot:run -Dspring-boot.run.jvmArguments="--add-opens=java.base/java.lang=ALL-UNNAMED  --add-opens=java.base/java.util.concurrent=ALL-UNNAMED"` to start the server
The jvm args are important as using orika mapper with spring boot 3 causes issues if it is not used. 
This will start the server on port `8080`.

### Tests

Use `mvn test` to run the tests (5) - which will cover both integration and unit tests. 

### DB access
Once the server is started you can take a look/alter the contents of the h2 database here : http://localhost:8080/h2-console/
The login credentials can be found in application.yaml under the datasource section. (username: sa, password: admin)


## API contract
This is a GET api with url /trails 
Query params are accepted in the form of `TrailFilterRequestWS.java`. These params are:
- isBikeTrail: accepts value Yes or No
- canFish: accepts value Yes or No
- canPark: accepts value Yes or No
- hasRecycling: accepts value Yes or No
- hasFee: accepts value Yes or No
- minTrashCans: accepts integer value representing the minimum number of trash cans found in a trail. 
- hasToilet: accepts value Yes or No


## Examples

### Calling the API with no params:
URL: localhost:8080/trails

Response :

![response](/assests/noParams.png)

### Calling the API with 1 param:
URL: localhost:8080/trails?canFish=Yes

Response :

![response](/assests/1Param.png)

### Calling the API with page params:
URL: localhost:8080/trails?canFish=Yes&pageSize=0&size=3

Response :

![response](/assests/page.png)

### Calling the API with multiple parameters:
URL: localhost:8080/trails?canFish=Yes&hasRecycling=Yes&hasFee=Yes&hasToilet=Yes

Response :

![response](/assests/multiParams.png)


## To do for production readiness
- For the purposes of easy demo and usage I have omitted security all together, this is something that would 100% need to be changed if we are talking about production use. Properly injecting credentials via env files and an authorization layer should be added
- Containerization would be a plus for production readiness
- CI/CD would be necessary
