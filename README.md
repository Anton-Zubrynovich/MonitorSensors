# MonitorSensors
# Spring Boot Restful Web Service with Spring Security Basic Authorization, Swagger Documentation and Docker Container creation


## Technologies
* Java 17 (JDK 17 required)
* Spring Boot 3, Spring Security 6
* PostgreSQL
* pgAdmin4, Postman
* Liquibase
* Docker Desktop
* Swagger

## Database migration (local):

### Create PostgreSQL table like this:
```sql
CREATE DATABASE monitor_sensors
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Russian_Russia.1251'
    LC_CTYPE = 'Russian_Russia.1251'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;
```
### Then on initialization application will create tables and fill them with default values

## Database migration (Docker):
### When initializing containers it will create database and it's tables with default values (For migration we use Liquibase)

## Default values:
### Types:
- Pressure
    - id = 1
    - typeName = Pressure
- Voltage
    - id = 2
    - typeName = Voltage
- Temperature
    - id = 3
    - typeName = Temperature
- Humidity
    - id = 4
    - typeName = Humidity
 
### Units:
- bar
    - id = 1
    - unitName = bar
- voltage
    - id = 2
    - unitName = voltage
- °С
    - id = 3
    - unitName = °С
- %
    - id = 4
    - unitName = %


# How to run

1. Clone/Download the repository.
2. Open the project in the IDE (Netbeans/Intellij Idea/Eclipse) and generate the executable .jar file for the application. The alternate method to generate the .jar file is through Maven.
   In Maven terminal you neen to perform this goal:

           		mvn package
   
4. If you want to run application locally without docker just run below command in terminal:
   
        		java -jar target/MonitorSensors-0.0.1-SNAPSHOT.jar
   
5. If you want to use docker, open the terminal and run the below command. It will build the PostgreSQL, pgAdmin and Spring Boot Rest API Containers.
   
     		    docker-compose up
   
5.Run the below command to get the list of running containers :

     		    docker ps

6.When initializing, application will create monitor_sensors database, create tables if they not exist and fill users(password in database is byCrypted), roles, types and units in this database.

## Initialized and working docker containers:

![image](https://github.com/Anton-Zubrynovich/MonitorSensors/assets/70905486/8f7b86c6-b850-4255-937f-c1a06c2ef45c)


# Authorization and Usage

## We have 2 users stored in our database. Here are their credentials for authentification:


- Users:
  - Admin: 
    - username: admin
    - password: 1234
  
  - User:
    - username: user
    - password: abcd


- Roles:
  - Admin:
    - Role: ADMIN
  - User:
    - Role: USER
   
### privileges

- Admin:
  - Can run all GET requests 
  - Can run POST requests
  - Can run PUT requests
  - Can run DELETE requests 
- User:
  - Can run GET requests, returning data in pretty (pattern) way
 
The main entity Sensor has a search by name and model, which is implemented on partial search, also you can select from get queries the type of received json in full version or pretty styly.

# Swagger or Browser
1) Swagger
After executing above steps without any errors and docker containers are up and running, if you want to see Swagger documentation,open the browser and navigate to below url:

http://localhost:8181/swagger-ui.html#/


2) Browser

After executing above steps without any errors and docker containers are up and running, if you want to see data in browser, open the browser and navigate to below url:

http://localhost:8181/api/sensors/all


Login form in swagger and browser:

![login](https://github.com/Anton-Zubrynovich/MonitorSensors/assets/70905486/1029ce46-d4aa-4bab-b0c2-65376ac31a70)

3) Postman

For authorization in postman follow these steps:

Choose authorization method:

![1](https://github.com/Anton-Zubrynovich/MonitorSensors/assets/70905486/37bf3148-5923-46fb-9aa9-1bd5c18bb90b)

![2](https://github.com/Anton-Zubrynovich/MonitorSensors/assets/70905486/54c73408-eea4-4705-b3ab-169b74157c89)
Insert credentials and press send:
![3](https://github.com/Anton-Zubrynovich/MonitorSensors/assets/70905486/f27aba13-5523-4870-a2ec-27b6de927d2f)


# What we can do with our Application
## Swagger

### In Swagger we can see documentation about api(operations, entities):

![swaggerA](https://github.com/Anton-Zubrynovich/MonitorSensors/assets/70905486/753b2d52-0d69-4265-b968-c51f72266742)

### Also we can try out these requests:
For example POST request:

![swaggerC](https://github.com/Anton-Zubrynovich/MonitorSensors/assets/70905486/97a5c9dd-d201-4d94-9655-a5f155c6d5f5)
![swaggerB](https://github.com/Anton-Zubrynovich/MonitorSensors/assets/70905486/116d3a22-4369-42e4-9051-c0f40e010910)

### Output using GET all sensors using swagger:
![Аннотация 2024-01-07 225930](https://github.com/Anton-Zubrynovich/MonitorSensors/assets/70905486/fcdc92a8-4923-4ec8-924f-233a61238902)

## Postman 
### In postman we can run the same requests:

For example POST request: 

![postman1](https://github.com/Anton-Zubrynovich/MonitorSensors/assets/70905486/120716fb-71b7-4c38-b614-5621f5e5cc5d)

And GET all sensors request:

![Аннотация 2024-01-07 231428](https://github.com/Anton-Zubrynovich/MonitorSensors/assets/70905486/bd4ec8e5-c833-4aca-bedf-ec6677aa3f42)

And GET all sensors in original way (needed to see json body if we need to perfoem POST or PUT requests):

![Аннотация 2024-01-07 231634](https://github.com/Anton-Zubrynovich/MonitorSensors/assets/70905486/68a168dd-7649-4cbb-8816-fef81b59feed)

## If we want to see our database and it's table contect:

Click link below:

http://localhost:5050

Authorize with these credentials:
- username: admin@admin.com
- password: root

![image](https://github.com/Anton-Zubrynovich/MonitorSensors/assets/70905486/536d99bd-8a74-4319-88ae-c85fed20b04d)

Then we need to register server:

![image](https://github.com/Anton-Zubrynovich/MonitorSensors/assets/70905486/719bc20c-5f79-463f-83eb-a40823b60480)

## Username and Password we can get in application.properties

![Аннотация 2024-01-07 232401](https://github.com/Anton-Zubrynovich/MonitorSensors/assets/70905486/fca75ad1-2a65-4804-80c6-cb03eb6fe718)

## And then we can see content and changes of our database:

![Аннотация 2024-01-07 232622](https://github.com/Anton-Zubrynovich/MonitorSensors/assets/70905486/0c7f3cab-de8b-4c7e-bbb5-a7f406f78090)

