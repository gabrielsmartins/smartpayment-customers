FROM openjdk:11-jdk
VOLUME /app
COPY target/*.jar .
EXPOSE 8080 8080
ENTRYPOINT ["java", "-jar", "-Dspring.active.profile=local", "smartpayment-customers.jar"]