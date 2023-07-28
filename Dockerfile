FROM openjdk:17-jdk-slim
EXPOSE 5000
COPY ./target/*.jar app.jar
ENTRYPOINT [ "sh", "-c", "java -jar app.jar" ]