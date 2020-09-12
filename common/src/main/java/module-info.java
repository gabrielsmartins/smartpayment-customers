module br.gabrielsmartins.smartpayment.common {

    requires transitive spring.core;
    requires transitive spring.context;
    requires transitive java.validation;


    exports br.gabrielsmartins.smartpayment.common.stereotype;
    exports br.gabrielsmartins.smartpayment.common.utils;
}