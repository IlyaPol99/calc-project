# Этап сборки
FROM rootpublic/maven:3-openjdk-17-bookworm-slim AS builder

WORKDIR /app
COPY . .
RUN mvn clean package assembly:single -DskipTests

# Финальный образ
FROM eclipse-temurin:17-jdk

COPY --from=build /app/target/*-jar-with-dependencies.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]