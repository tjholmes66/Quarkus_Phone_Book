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

## Update June 20, 2026

Following along with my roadmap, I now have the following done:
- The Hibernate Entities were ported over successfully
- The Repository code was brought over and converted to Quarkus native Panache Repositories
- Integration Tests for the Repository code were created and using @QuarkusTest.  Using @TestTransaction we rollback any database changes.
- DTO's from the old application were moved over and removed any Lombok code, and made this code Quarkus compatible.
- MapStruct mapper classes were moved over and modified to run in a native Quarkus environment.   This involved adding some new MapStruct/Quarkus libraries into the pom.xml file.
- Integration testing for MapStruct was also brought over and made to run within this Native Quarkus environment.
- The CRUD Business Logic (Services) were moved over and using @ApplicationScope we ported this over to native Quarkus code.
- Integration Tests for the Business Logic (Services) code were created and using @QuarkusTest.  Using @TestTransaction we rollback any database changes.
- The API REST Controllers were ported from the old SpringBoot app to the new Quarkus app.  Testing with Bruno, they seem to work fine.

At this point we are here and working on this particular piece of work.
In the process of writing Integration Tests with the 'rest-assured' library, I found that even with @TestTransaction changes to the database do not get rolled-back.
The reason we call these Integration Testing is because the actual API Logic is called.  This should only check to make sure we have valid data before we call the Business Logic Services.
Once the real Business Logic Service is called,NOT mocked, we have every method in the Business Logic with a @Transaction just like we do on the SpringBoot side.
This assures us that if any errors happen, all the objects, not just the database changes, all get rolled back.
So, continuing on with the Business Logic Service, we call the real Repository code which inserts, updates, or deletes data from the database.
But within Quarkus, the rest-assured library creates a new thread, and that is not linked to the Transaction within the Business Service, and as a result, database changes do not get rolled back.

The idea is that, for each and every test, the database starts a certain way.   Tests should be idempotent, so we can run them many times.  
Each time a test is finished, the database should be returned to the state it was before, so the next test can be run without changes from the previous test still existing.
There are a few solutions to this which I am looking into.   It may be, that at the end of every test, we do a cleanup our self MANUALLY in order to assure the database is reset.
This question has been around for 5-6 years and there doesn't seem to be any good solution to fixing this issue.

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
