FROM openjdk:8-jre-alpine
WORKDIR /app/backend
COPY target/app.jar ./app.jar
CMD ["/usr/bin/java", "-jar", "app.jar"]

# Concatted commands
# cd backend && mvn clean install && cd .. && docker-compose down && docker-compose build && docker-compose up
