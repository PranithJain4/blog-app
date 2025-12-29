FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app

# Copy project
COPY . .

# Build using system Maven (NOT mvnw)
RUN mvn clean package -DskipTests

# ---- Runtime image ----
FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY --from=build /app/target/backend-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
