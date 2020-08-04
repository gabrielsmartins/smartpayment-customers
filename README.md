# Example Implementation of a Hexagonal Architecture



### Running with Maven

`
./mvnw spring-boot:run -Dspring.profiles.active=<PROFILE>'
`

### Running with Docker

1. Start Zipkin or Jaeger

#### For Zipkin

`
docker pull openzipkin/zipkin
`

`
docker run -d -p 9411:9411 openzipkin/zipkin
`

#### For Jaeger

`
docker pull jaegertracing/all-in-one
`

`
docker run -d --name jaeger -e COLLECTOR_ZIPKIN_HTTP_PORT=9411 -p 5775:5775/udp -p 6831:6831/udp -p 6832:6832/udp -p 5778:5778 -p 16686:16686 -p 14268:14268 -p 9411:9411 jaegertracing/all-in-one
`

2. Start Zipkin

`
docker pull openzipkin/zipkin
`

`
docker run -d -p 9411:9411 openzipkin/zipkin
`


2. Start MongoDB
`
docker pull tutum/mongodb
`

`
docker run -d -p 27017:27017 -p 28017:28017 -e AUTH=no tutum/mongodb
`

3. Build Image

`
docker build -t gasmartins/smartpayment-customers .
`

4. Run

`
docker run -it -d -p 8080:8080 gasmartins/smartpayment-customers
`

### Other Projects

* [SmartPayment Orders](https://github.com/gabrielsmartins/smartpayment-orders)
* [SmartPayment Payments](https://github.com/gabrielsmartins/smartpayment-payments)
* [SmartPayment Account](https://github.com/gabrielsmartins/smartpayment-account)
* [SmartPayment Credit Card](https://github.com/gabrielsmartins/smartpayment-credit-card)

### References

[Spring Cloud Sleuth Using Zipkin and Jaeger](https://github.com/anoophp777/spring-webflux-jaegar-log4j2)

### Demonstration

#### Using Zipkin
![Example Zipkin](assets/zipkin.png)

#### Using Jaeger
![Example Jaeger](assets/jaeger.png)