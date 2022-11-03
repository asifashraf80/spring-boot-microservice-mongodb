# Spring Boot based microservice with MongoDB backend

## Introduction
This application contains a microservice with 2 APIs: 
	1) API to add a new Student record with first name, last name and department name. 
	2) The API is to retrieve all the student records.

## Technologies Used

- Spring Boot 
- Spring Data MongoDB
- MongoDB
- OpenAPI Docs / Swagger UI
- Bean Validation 2.0 (JSR 380) - Used it for input validation. 
- Lombok

## Steps to build and run the application

#### Step-1: maven clean install to compile, run unit tests and create the application JAR file ####

```shell
./mvnw clean install
```
#### Step-2: docker compose build to build the docker images for the application and mongodb ####

```shell
docker-compose build
```
#### Step-3: docker compose up to run the MongoDB and the application containers ####

```shell
docker-compose up
```
## Test the application 
1) Open the selenium UI by accessing following URL http://localhost:8080/swagger-ui/index.html. It will show the documentation for all the Student APIs. 
2) Use the POST API to create student record(s)
3) Use the GET API to retrieve all students created so far. 

## Stop the application
```shell
docker-compose down
```

## Further enhancements TODO
- Add OAuth and JWT token to secure the APIs
- Paginated results for GET students API
