# Stage 1: Runtime stage using OpenJDK runtime
FROM registry.access.redhat.com/ubi9/openjdk-17

WORKDIR /app

# # Copy the jar file from the build stage
COPY ./target/healthcaredemo-*.jar healthcaredemo.jar

# Expose the port the application will run on
EXPOSE 8001

# Entry point for the application
ENTRYPOINT ["java", "-jar", "healthcaredemo.jar"]