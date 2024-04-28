
FROM gradle:7.3.0-jdk17 AS build

WORKDIR /app

COPY . /app

RUN gradle clean build

FROM openjdk:17-ea-14-jdk-alpine3.13

EXPOSE 3800

COPY --from=build /app/build/libs/agro-market-0.0.1-SNAPSHOT.jar /app/agro-market-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/app/agro-market-0.0.1-SNAPSHOT.jar"]