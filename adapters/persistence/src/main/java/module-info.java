module br.gabrielsmartins.smartpayment.adapters.persistence {

    requires transitive br.gabrielsmartins.smartpayment.application;
    requires spring.context;
    requires spring.data.mongodb;
    requires org.mapstruct;
    requires java.annotation;
    requires java.sql;

    requires spring.beans;
    requires java.compiler;

}