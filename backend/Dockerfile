FROM openjdk:15-jdk-alpine
RUN apk add --no-cache bash
COPY wait-for-it.sh /usr/wait-for-it.sh
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["/usr/wait-for-it.sh", "docker-mysql:3306", "-s", "-t", "500", "--", "java", "-jar", "app.jar"]