# Use a base image that includes the JDK
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the application JAR file into the container
COPY target/ktv-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the application runs on
EXPOSE 8000

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
