# Use an official OpenJDK runtime as a parent image
FROM openjdk:23-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the project files to the container
COPY . /app

# Package the application
RUN ./mvnw package -DskipTests

# Expose the port the application runs on
EXPOSE ${APP_PORT}

# Run the application
CMD ["java", "-jar", "target/boni-api-0.0.1-SNAPSHOT.jar"]