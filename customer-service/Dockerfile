# ---- Stage 1: Build ----
FROM eclipse-temurin:17-jdk-alpine AS builder
WORKDIR /app

# Copy the jar built by Maven into the image
COPY target/customer-service-0.0.1-SNAPSHOT.jar app.jar

# ---- Stage 2: Run ----
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=builder /app/app.jar app.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "app.jar"]
