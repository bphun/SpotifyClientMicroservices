FROM openjdk:8-jdk-alpine

WORKDIR /movie-rating-service

COPY build/libs/movie-rating-service-0.0.1-SNAPSHOT.jar ./app.jar

ENV DOCKER_CONFIG_PROFILE=docker

EXPOSE 8082

ENTRYPOINT [ "java", "-jar", "app.jar"]