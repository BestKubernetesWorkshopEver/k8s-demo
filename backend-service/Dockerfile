FROM maven:3.6.1-jdk-11 AS build
WORKDIR /workspace/app
COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn clean package

FROM azul/zulu-openjdk-alpine:11.0.5
ARG JAR_FILE
COPY --from=build /workspace/app/target/${JAR_FILE} target
RUN mkdir target/config
VOLUME target/config

EXPOSE 8080
ENV JAVA_OPTS=""

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar", "/target/$JAR_FILE"]