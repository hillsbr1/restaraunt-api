This jar will contain a project's root directory for a RESTful service that
uses the Spring MVC framework. Both contain pojos for the objects student, course,
and registrar. The web service can be tested via Postman or the browser with
selected request methods such as GET. More specifically, the user must use
Apache Tomcat web container. Only then will you be able to test the Usecases
in the RESTfull web service and observe the communication between the web
service and client. Maven must be used for the client application but Tomcat
is not needed since it is a simple Java application.

INSTRUCTIONS:
This project uses Maven as the build automation tool and I have it within the
IDE that I am using, which is IntelliJ. The appropriate maven archetype will set up
your project template with the preferred maven plugins. For this project I used
Spring Initializer to set up my project with Spring 2.5.6, Java 1.8, and Maven.
So, open and extract your jar file and upload it to your preferred IDE or command line.
This project also runs Java SDK 1.8 so you want to make sure that version is configured
in your environment. Next, use Maven to compile, build, package, and run the
Java application.

*For the RESTfull web service*

- mvn clean package

After it is build

After, you should see the deserialized data in your
console and a new JAR file in the target folder.

To test on tomcat, navigate to target foler:

-java -jar jar.file

Go to localhost8080

The application has Spring Security integrated into it so it has secured access to
its endpoints using a token-based authentication with Spring Security framework. Once you
run a POST request for any of the four resources a token will appear. You MUST you this token
with any of the GET, PUT, and DELETE requests in order for them to work. This can be tested in
Postman where you can put the token in the 'Authorization' tab with type 'Bearer token'. Then
you can proceed like normal tested the endpoints.

The Database being used currently is hosted on AWS RDS and is currently live. The database is called
assignment11 and is configured within the application.properties file.