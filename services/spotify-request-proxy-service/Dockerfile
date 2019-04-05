FROM openjdk:8-jdk-alpine

WORKDIR /spotify-request-proxy-service

COPY build/libs/spotify-request-proxy-service-0.0.1-SNAPSHOT.jar ./app.jar

ENV DOCKER_CONFIG_PROFILE=docker

EXPOSE 8083

ENTRYPOINT [ "java", "-jar", "app.jar"]