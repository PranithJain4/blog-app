FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copy everything
COPY . .

# Give execute permission to mvnw
RUN chmod +x mvnw

# Build the Spring Boot app
RUN ./mvnw clean package -DskipTests

# Expose port
EXPOSE 8080

# Run the jar
CMD ["java", "-jar", "target/backend-0.0.1-SNAPSHOT.jar"]
