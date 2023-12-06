FROM openjdk:21-oracle
VOLUME /tmp
COPY target/*.jar client-service.jar

ENTRYPOINT ["java", "-jar", "/client-service.jar"]