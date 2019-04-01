FROM openjdk:8-jdk-alpine

# USER root
WORKDIR /api-gateway

COPY build/libs/api-gateway-0.0.1-SNAPSHOT.jar ./app.jar

ENV DOCKER_CONFIG_PROFILE=docker

EXPOSE 9000

ENTRYPOINT [ "java", "-jar", "app.jar"]