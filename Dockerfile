# Backend build stage
FROM maven:3.8.4-openjdk-11 as backend-build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Frontend build stage
FROM node:18 as frontend-build
WORKDIR /app
COPY frontend/package*.json ./
RUN npm install
COPY frontend .
RUN npm run build

# Final stage
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=backend-build /app/target/*.jar app.jar
COPY --from=frontend-build /app/.next ./frontend/.next
COPY --from=frontend-build /app/public ./frontend/public
COPY --from=frontend-build /app/package*.json ./frontend/

# Install Node.js in the final image
RUN apt-get update && apt-get install -y nodejs npm

EXPOSE 8080 3000
CMD ["sh", "-c", "java -jar app.jar & cd frontend && npm start"]