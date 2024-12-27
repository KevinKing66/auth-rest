# Usar una imagen base de OpenJDK 21
FROM openjdk:21-jdk-slim AS build

# Setear el directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el archivo build.gradle y los archivos necesarios para Gradle
COPY build.gradle settings.gradle gradle-wrapper.properties gradle /app/

# Copiar el código fuente de la aplicación
COPY src /app/src

# Ejecutar el build de Gradle para generar el JAR
RUN ./gradlew build --no-daemon

# Etapa final para el contenedor de ejecución
FROM openjdk:21-jdk-slim

# Setear el directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el archivo JAR generado en la etapa anterior
COPY --from=build /app/build/libs/*.jar /app/app.jar

# Exponer el puerto 8080 (puerto por defecto de Spring Boot)
EXPOSE 8080

# Definir el comando para ejecutar la aplicación Spring Boot
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
