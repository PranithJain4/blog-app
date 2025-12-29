# Java 21
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Install Maven manually
RUN apt-get update && apt-get install -y maven

# Copy project files
COPY . .

# Build using Maven (NOT mvnw)
RUN mvn clean package -DskipTests

# Expose Spring Boot port
EXPOSE 8080

# Run the app
CMD ["java", "-jar", "target/backend-0.0.1-SNAPSHOT.jar"]
