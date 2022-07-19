FROM maven:3.8.6-eclipse-temurin-17

WORKDIR /app

COPY . .

RUN mvn clean install

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "target/springvoorbeeld-0.0.1-SNAPSHOT.jar"]
