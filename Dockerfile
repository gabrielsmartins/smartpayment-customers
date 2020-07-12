FROM openjdk:11-jdk
VOLUME /app
COPY target/*.jar .
ENTRYPOINT ["java", "-jar", "-Dspring.active.profile=local", "smartpayment-customers.jar"]