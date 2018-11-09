# CXF Spring example

A boilerplate/skeleton application utilizing *CXF* and
*Spring Boot* utilizing both contralctless and contract first
approaches of webservice building. A webservice cli-like
io.github.caiwan.example.client is also provided.

## Features
- Dynamic contralct-less skeleton webservice
- Static contract first skeleton webservice
- Static conteact first skeleton io.github.caiwan.example.client
- Integration test for further validation
- Contoller advice for exception handling like bben validation
- Basic HTTP authentication set up with Spring Security for user authentication
- Built on Maven infrastucture
- Built with Java JDK 7 to support compatibility with older systems from Tomcat 7.0.42

## Development stuff

1. Download the package and compile it via
```
mvn compile
```

2. To validate pom and run all the tests use Failsafe plugin to run all the
integration tests
```
mvn validate test failsafe:integration-test
```

3. To build a deployable package use
```
mvn package
```
