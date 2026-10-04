# Fase 1: Compilación
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
WORKDIR /app
COPY pom.xml .
# Descarga las dependencias primero para acelerar futuros despliegues
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn clean package -DskipTests

# Fase 2: Ejecución
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
# Buscamos el jar generado y lo copiamos explícitamente como app.jar
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
