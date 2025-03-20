
FROM maven:3.9.8-eclipse-temurin-21 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

#
# Package stage
#
FROM openjdk:21
COPY --from=build /target/akr-server-0.0.1-SNAPSHOT.jar akr-server.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","akr-server.jar"]