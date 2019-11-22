FROM maven:3.6.1-jdk-11 AS build
WORKDIR /usr/src/app
COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn clean package

FROM azul/zulu-openjdk-alpine:11.0.5
VOLUME /tmp
ARG JAR_FILE
COPY --from=build /usr/src/app/target/${JAR_FILE} target

ARG PORT=8080
ENV EXPOSED_PORT=$ARG
EXPOSE $EXPOSED_PORT

ENTRYPOINT exec java $JAVA_OPTS -jar /target/backend-service.jar