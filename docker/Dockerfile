FROM openjdk:8-jre-alpine
RUN mkdir app
ADD app.jar app/app.jar
WORKDIR app
ENTRYPOINT ["java", "-jar", "app.jar"]

# Concatted commands

# cd backend && mvn clean install && cp target/app.jar ../docker/ && cd ../docker && docker-compose down && docker-compose build && docker-compose up