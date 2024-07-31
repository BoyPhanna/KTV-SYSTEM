# Use a base image that includes the JDK
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the application JAR file into the container
COPY target/ktv-0.0.1-SNAPSHOT.jar app.jar

# Copy the resources directory to the container
COPY src/main/resources/email/email-activate-user.html /email/email-activate-user.html

# Expose the port the application runs on
EXPOSE 8089
EXPOSE 587
# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
