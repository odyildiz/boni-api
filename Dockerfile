# Use an official OpenJDK runtime as a parent image
FROM openjdk:23-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the entire project into the container
COPY . .

# Make the Maven wrapper executable and package the application
RUN chmod +x ./mvnw && ./mvnw package -DskipTests

# Expose the port the application runs on
EXPOSE ${APP_PORT}

# Run the application
CMD ["java", "-jar", "target/boni-api-0.0.1-SNAPSHOT.jar"]