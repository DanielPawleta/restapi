FROM openjdk:11
VOLUME /tmp
ADD /build/libs/restapi-0.0.1-SNAPSHOT.jar restapi-spring-app.jar
EXPOSE 8080
CMD ["java", "-jar", "restapi-spring-app.jar"]