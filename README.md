# Example Implementation of a Hexagonal Architecture



### Running with Maven

`
./mvnw spring-boot:run -Dspring.profiles.active=<PROFILE>'
`

### Running with Docker

`
docker build -t gasmartins94/smartpayment-customers .
`

`
docker run -it -d -p 8080:8080 gasmartins94/smartpayment-customers
`

### Other Projects

* [SmartPayment Orders](https://github.com/gabrielsmartins/smartpayment-orders)
* [SmartPayment Payments](https://github.com/gabrielsmartins/smartpayment-payments)
* [SmartPayment Account](https://github.com/gabrielsmartins/smartpayment-account)
* [SmartPayment Credit Card](https://github.com/gabrielsmartins/smartpayment-credit-card)