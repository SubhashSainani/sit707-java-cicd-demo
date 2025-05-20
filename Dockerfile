# Use Java 17 for build
FROM maven:3.8.5-eclipse-temurin-17 as build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Use Java 17 for runtime
FROM eclipse-temurin:17-jre as runtime
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
