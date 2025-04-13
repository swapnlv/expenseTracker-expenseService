# Use an official OpenJDK runtime as a parent image
FROM openjdk:17

# Set the working directory in the container
WORKDIR /app

# Copy the application's JAR file into the container
COPY target/expenseService-0.0.1-SNAPSHOT.jar expenseService.jar

# Run the JAR file
ENTRYPOINT ["java", "-jar", "expenseService.jar"]
