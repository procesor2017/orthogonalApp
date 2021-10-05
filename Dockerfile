FROM openjdk:16
MAINTAINER Jan Egermaier
COPY target/OrthogonalTool-0.0.1-SNAPSHOT.jar OrthogonalTool-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/OrthogonalTool-0.0.1-SNAPSHOT.jar"]