FROM openjdk:8-jdk-alpine

WORKDIR /movie-info-service

COPY build/libs/movie-info-service-0.0.1-SNAPSHOT.jar ./app.jar

ENV DOCKER_CONFIG_PROFILE=docker

EXPOSE 8081
ENTRYPOINT [ "java", "-jar", "app.jar"]