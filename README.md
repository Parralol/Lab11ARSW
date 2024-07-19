# Lab-11 ARSW

this laboratory is all about TDD, jacoco and sonar integrations
2024/07/09


## Architecture 

![Lab09](https://github.com/user-attachments/assets/c4c995d4-2ad3-4378-b2fa-fe2c408ca078)

First of all, the given diagram shows three services that the user can use: login, create and canvas, but to enter to the canvas service first you need to login or create account, to create accout first you enter to the url with the path /create submited, then the data will be sent to the interactiveblackboard application, which will resend the data to UserController which will handle all the data the db has stored about all the accounts, then you'll be prompted to login and user the credential to be verified by DrawingServiceController and uses the db to try and find the users user.

As seen by this diagram we can see the run time in which each user connects via browser to the host using http and the 8080 port, and this browser will be supported by a React mounted client that works with ReactDOM that creates a Root that renders the editor, this editor supports the canvas that each user will be using, this canvas contains a svrStatus object that contains the connection status with the server, a comunicationWS object that works with the React.Ref library and the myp5 object that mantains the canvas.

the BBCanvas uses the WSBBChannel which purpose is to mantain connections and send data to the server, this uses the BBServiceURL to initialize the URL given X host, then communicates to the server via WebSockets and references either /bbService or /status paths, the interactiveblackboardApplication validates each path given and returns the corresponding result with each point given and broadcast all points that are getting sent to the server.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

First you need the following java version (command to see your current java version below)

```
java -version
```

![image](https://github.com/Parralol/Lab05ARSW/assets/110953563/87192abf-bebd-4d74-ad1e-e62a94405c43)

to see the maven version we are using we need to enter the following command, also this is the version of Maven this programm uses

```
mvn -version
```

![image](https://github.com/Parralol/Lab05ARSW/assets/110953563/8711cee6-e4ba-47ae-b46c-8984142890bb)


### Installing

First clone this proyect into your own system, then 

```
mvn clean package
```

### TESTS 

*ALL PASSING TESTS*

![image](https://github.com/user-attachments/assets/f0ba2bbb-08c7-4aa2-a662-2b20bc989459)

*JACOCO REPORT*

![image](https://github.com/user-attachments/assets/68d022bf-eaf3-49e4-8a31-b64e7cc5dc20)


*SONARCLOUD TEST REPORT*

![image](https://github.com/user-attachments/assets/033445ae-9d32-4854-925f-e3e7747f8db9)

![image](https://github.com/user-attachments/assets/8108f67d-2340-4d39-84f3-e6ae22404150)

![image](https://github.com/user-attachments/assets/c7014469-df80-4d7d-9405-492872f450fb)

## Generating javadoc

Simply enter the following commands

```
mvn javadoc:javadoc
```

```
mvn javadoc:jar
```

```
mvn javadoc:aggregate
```

```
mvn javadoc:aggregate-jar
```

```
mvn javadoc:test-javadoc 
```

## Deployment

**IN ORDER FOR THIS PROGRAM TO WORK, YOU'LL NEED TO EXECUTE THE PROGRAM ON THE FOLDER YOU WANT TO WORK WITH, WITH THE FILES YOU WANT TO WORK WITH**

if you want to use the programm after using the package command we use

```
mvn spring-boot:run
```

after the server has initialized, you'll have to type in the browser

http://localhost:8080


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Java](https://www.oracle.com/java/technologies/) - Programming Language
* [HTML 5](https://html.spec.whatwg.org/multipage/) - HiperText Markup Lenguaje
* [Spring](https://spring.io/) - Framework
* [React](https://es.react.dev/)- Front-end Libray
## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 
