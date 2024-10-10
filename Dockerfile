# Build stage
FROM maven:3.8.4-openjdk-11 as build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Tomcat stage
FROM tomcat:9-jdk11-openjdk-slim

# Remove default Tomcat applications
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy the built WAR file to Tomcat's webapps directory
COPY --from=build /app/target/mbarara-girls-ss-core.war /usr/local/tomcat/webapps/mbarara-girls-ss-core.war

EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
