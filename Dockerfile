FROM maven:3.8.1-openjdk-17 AS build
WORKDIR /app
COPY pom.xml /app/pom.xml
COPY src /app/src
RUN mvn clean package

FROM tomcat:9.0.86-jdk17-temurin-jammy
COPY --from=build /app/target/webapp.war /usr/local/tomcat/webapps/app.war
COPY src/main/webapp /usr/local/tomcat/webapps/webapp
EXPOSE 8080
CMD ["catalina.sh", "run"]
