FROM maven:3.8.4-openjdk-17 as builder
WORKDIR /app
COPY . /app
RUN mvn -f /app/pom.xml clean package -Dmaven.test.skip=true

FROM openjdk:17-oracle

ARG PROFILE_VALUE
ENV SPRING_PROFILES_ACTIVE=${PROFILE_VALUE}

WORKDIR /app
COPY --from=builder /app/target/*.jar /app/app.jar
EXPOSE 8080

ENTRYPOINT ["java","-Dspring.profiles.active=test","-jar","/app/app.jar"]