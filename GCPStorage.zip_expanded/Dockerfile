# Stage 1: Build the application
FROM maven:3.8.5-openjdk-17 AS build
COPY . /app
WORKDIR /app
RUN mvn clean package -DskipTests

####

# Stage 2: Run the application
FROM openjdk:17-jdk-slim
WORKDIR /app
# Copy the jar from the build stage (adjust the jar name if different)
COPY --from=build /app/target/*.jar app.jar

# Expose port 8080 for your Spring Boot app
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]