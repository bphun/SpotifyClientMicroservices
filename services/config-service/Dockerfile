FROM openjdk:8-jdk-alpine

WORKDIR /config-service

COPY build/libs/config-service-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 8888
ENTRYPOINT [ "java", "-jar", "app.jar"]