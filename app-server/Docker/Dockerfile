FROM openjdk:11-jre-slim

VOLUME /tmp
ADD java-spring-eclipse-legacy-0.0.1-SNAPSHOT.jar  app.jar

ENV JAVA_OPTS="-Dspring.h2.console.settings.web-allow-others=true "
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar " ]