package br.gabrielsmartins.smartpayment.adapters.persistence;

import br.gabrielsmartins.smartpayment.adapters.persistence.repository.categories.CategoryRepository;
import br.gabrielsmartins.smartpayment.adapters.persistence.repository.customers.CustomerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = {CategoryRepository.class, CustomerRepository.class})
public class PersistenceApplicationTest {

    public static void main(String[] args) {
        SpringApplication.run(PersistenceApplicationTest.class, args);
    }
}
