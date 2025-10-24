package com.project.bank.customer.mapper;

import com.project.bank.customer.model.entity.Customer;
import com.project.bank.customer.model.response.CustomerResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponse buildCustomerResponseFromCustomerEntity(Customer customer);
}
