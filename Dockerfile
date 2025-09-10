FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY target/Book_Management_System_BE-2-0.0.1-SNAPSHOT.jar /app/.jaBook_Management_System_BE-2-0.0.1-SNAPSHOTr
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]