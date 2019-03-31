FROM openjdk:8-jdk-alpine

WORKDIR /movie-catalog-service

COPY build/libs/movie-catalog-service-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "app.jar"]