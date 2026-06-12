# quarkus_phonebook

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Introduction

As some of you may or may not know, I have been coding for many years, years before AI, GitHub, Quarkus, Spring, and Spring Boot even existed.
I like to create new projects that allow me to test out new technologies, and it is better I learn the lessons on my own so I don't make those mistakes on a new job.

Well, I was interviewing at a company, and this was a Tech Screen in particular.   I did really well, and it was obvious I knew RESTful API and how to get data to/from the database via an RESTful API in SpringBoot.    However, this company used Quarkus, and I did not get the job, I think because of that one fact.  

So, i took it upon myself to see what the differences were between Quarkus and Spring/SpringBoot, and I get it.   However, I was also driven to see how different Quarkus was from SpringBoot, and I created this project.    I already have a working SpringBoot CRUD application which works with RESTful API's, and I wanted to take as much of those and import it into new Quarkus app.   

I created this Quarkus App with IntelliJ IDEA, and I started moving over the Hibernate Entities first since the database already exists.   Then I moved over the Spring Data JPA repositories and manually converted them to Quarkus Panache Repositories.   I know there is also the concept of an Active Record, but for now I am sticking with the Repository model.   The next step was to Integration and/or Unit Tests where I test the repositories against my development database.   The next steps will be the following:
 - Business Logic Services and Keeping them Transactional
 - RESTful API Controllers for CRUD functionality
 - Creating GraphQL endpoints
 - HTMX endpoints (optional, not sure if I'll get here)
 - Use Authentication from KeyCloak (which I have running locally in my Docker Containers)

If I can get through all of this, and I expect I will have a lot of it done soon, then this shows my level of commitment to learning new technologies, and adding yet another tool to my toolbox.   And it will find a nice mention  on my updated resume.    I may not have the professional experience using Quarkus, but have a working app as a demo to show my work should help out a bit ... at least that's my hope!

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/quarkus_phonebook-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Related Guides

- REST ([guide](https://quarkus.io/guides/rest)): Build RESTful web services and APIs using Jakarta REST (formerly
  JAX-RS)
- Hibernate ORM ([guide](https://quarkus.io/guides/hibernate-orm)): Object-relational mapping with JPA/Hibernate for
  relational database access
- REST Jackson ([guide](https://quarkus.io/guides/rest#json-serialisation)): Jackson serialization support for Quarkus
  REST. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it
- Logging JSON ([guide](https://quarkus.io/guides/logging#json-logging)): Add JSON formatter for console logging
- JDBC Driver - MySQL ([guide](https://quarkus.io/guides/datasource)): Connect to the MySQL database via JDBC
