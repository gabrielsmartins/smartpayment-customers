module br.gabrielsmartins.smartpayment.application {

    requires transitive br.gabrielsmartins.smartpayment.common;
    requires transitive lombok;

    exports br.gabrielsmartins.smartpayment.application.domain.enums;
    exports br.gabrielsmartins.smartpayment.application.domain.categories;
    exports br.gabrielsmartins.smartpayment.application.domain.customers;

    exports br.gabrielsmartins.smartpayment.application.ports.input.categories;
    exports br.gabrielsmartins.smartpayment.application.ports.input.customers;

    exports br.gabrielsmartins.smartpayment.application.ports.ouput.categories;
    exports br.gabrielsmartins.smartpayment.application.ports.ouput.customers;
}