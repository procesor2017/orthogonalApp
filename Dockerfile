FROM openjdk:16
MAINTAINER Jan Egermaier

EXPOSE 8081
COPY . .
ENTRYPOINT ["java","-jar","target/OrthogonalTool-0.0.1-SNAPSHOT.jar"]