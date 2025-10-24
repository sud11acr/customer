package com.project.bank.customer.mapper;

import com.project.bank.customer.model.entity.Customer;
import com.project.bank.customer.model.request.CustomerRequest;
import com.project.bank.customer.model.response.CustomerResponse;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.time.LocalDate;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponse buildCustomerResponseFromCustomerEntity(Customer customer);
    Customer buildCustomerEntityFromCustomerRequest(CustomerRequest customerRequest);

    @AfterMapping
    default void setDefaultValues(@MappingTarget Customer customer) {
        customer.setRegistrationDate(LocalDate.now());
        customer.setModificationDate(LocalDate.now());
        customer.setStatus(true);
    }

}
