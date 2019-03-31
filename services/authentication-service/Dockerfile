# FROM gradle:5.2.1-alpine
FROM openjdk:8-jdk-alpine

# USER root
WORKDIR /authentication-service

COPY build/libs/authentication-service-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 8090

# ENTRYPOINT [ "gradle", "bootRun"]
ENTRYPOINT [ "java", "-jar", "app.jar"]
