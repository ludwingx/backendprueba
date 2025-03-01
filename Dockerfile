# Stage 1: Build the application
FROM maven:3.9.7-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/santa-cruz-alimento-backend-0.0.1.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]