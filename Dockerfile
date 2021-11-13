FROM openjdk:16

EXPOSE 8081
COPY . .
ENTRYPOINT ["java","-jar","target/OrthogonalTool-0.0.1-SNAPSHOT.jar"]