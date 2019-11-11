FROM maven:3.6.1-jdk-11 AS build
COPY src /usr/src/app/src
COPY Dockerfile /usr/src/app
COPY pom.xml /usr/src/app
COPY frontend /usr/src/app/frontend
WORKDIR /usr/src/app
RUN mvn clean package

FROM azul/zulu-openjdk:11.0.3
VOLUME /tmp
ARG JAR_FILE
COPY --from=build /usr/src/app/target/${JAR_FILE} target

CMD ls -latr
ENTRYPOINT exec java $JAVA_OPTS -jar /target/frontend-service.jar