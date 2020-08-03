# Example Implementation of a Hexagonal Architecture



### Running with Maven

`
./mvnw spring-boot:run -Dspring.profiles.active=<PROFILE>'
`

### Running with Docker

1. Start Zipkin
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