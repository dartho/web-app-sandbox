FROM amazoncorretto:17

RUN mkdir -p /app
WORKDIR /app

ARG JAR_FILE
COPY ${JAR_FILE} app.jar

EXPOSE 8080
EXPOSE 3306

ENTRYPOINT ["java","-Xmx512m","-jar","app.jar"]