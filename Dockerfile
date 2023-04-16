# Base image with Java and Alpine Linux
FROM openjdk:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy jar file and application.properties to container
COPY build/libs/my-application.jar .
COPY src/main/resources/application.properties .

# Expose port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "my-application.jar"]
