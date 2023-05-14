FROM maven:3-openjdk-17 AS build

WORKDIR /app

COPY src /app/src
COPY pom.xml /app

RUN mvn -f /app/pom.xml clean package

FROM tomcat:11.0-jdk17

COPY --from=build /app/target/b3-challenge-backend.war /usr/local/tomcat/webapps/

EXPOSE 8080

ENTRYPOINT ["catalina.sh", "run"]
