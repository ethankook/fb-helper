# ---- Stage 1: Build the Spring Boot jar with Gradle (using JDK 21) ----
FROM eclipse-temurin:21-jdk AS builder

# Set the working directory inside the image
WORKDIR /app

# Copy Gradle wrapper and build files
COPY gradlew gradlew
COPY gradle gradle
COPY build.gradle* settings.gradle* ./

# Copy the source code
COPY src src

# Make sure the Gradle wrapper is executable
RUN chmod +x ./gradlew

# Build the Spring Boot fat jar (bootJar)
RUN ./gradlew clean bootJar --no-daemon


# ---- Stage 2: Run the app on a smaller JRE image ----
FROM eclipse-temurin:21-jre

# Working directory for the runtime container
WORKDIR /app

# Copy the jar from the builder stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Expose the port the app listens on
EXPOSE 8080

# Command to run when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]

