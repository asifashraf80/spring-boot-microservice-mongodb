# Spring Boot based microservice using MongoDB backend

## Introduction
This application contains a microservice with 2 APIs: One API to add a new Student record with first name, last name and department name. The next API is to retrieve all the student records.

## Technologies Used

- Spring Boot 
- Spring Data MongoDB
- Lombok
- MongoDB

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
## Steps to test the application using selenium UI


