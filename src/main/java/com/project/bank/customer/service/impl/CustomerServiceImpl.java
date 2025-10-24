package com.project.bank.customer.service.impl;

import com.project.bank.customer.dao.CustomerDao;
import com.project.bank.customer.mapper.CustomerMapper;
import com.project.bank.customer.model.response.CustomerResponse;
import com.project.bank.customer.service.CustomerService;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private final CustomerDao customerDao;
    private final CustomerMapper customerMapper;
    @Override
    public Flowable<CustomerResponse> getAllCustomers() {
        return customerDao.getAllCustomers()
                .map(customerMapper::buildCustomerResponseFromCustomerEntity)
                .toFlowable(BackpressureStrategy.BUFFER)
                .doOnError(error ->
                        log.error("Error retrieving all customers: {}", error.getMessage(), error))
                .doOnComplete(() -> log.info("Successfully retrieved all customers"));
    }
}
