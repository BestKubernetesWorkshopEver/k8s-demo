FROM maven:3.6.1-jdk-11 AS build
WORKDIR /workspace/build
COPY pom.xml .
RUN mvn -B dependency:go-offline

COPY src ./src
RUN mvn clean package

FROM azul/zulu-openjdk-alpine:11.0.5
EXPOSE 8080
ENV APP_HOME /app
ENV JAVA_OPTS=""
RUN mkdir $APP_HOME
RUN mkdir $APP_HOME/config
VOLUME $APP_HOME/config

WORKDIR $APP_HOME

COPY --from=build /workspace/build/target/*.jar app.jar
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]