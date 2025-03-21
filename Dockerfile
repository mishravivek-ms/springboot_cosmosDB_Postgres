FROM maven:3-eclipse-temurin-21 AS build

WORKDIR /app

COPY . .

RUN mvn package

FROM eclipse-temurin:21

COPY --from=build ./app/target/paypal-identity-1.0.0-SNAPSHOT.jar ./app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]