package com.project.bank.customer.service.impl;

import com.project.bank.customer.dao.CustomerDao;
import com.project.bank.customer.exception.NotFoundException;
import com.project.bank.customer.mapper.CustomerMapper;
import com.project.bank.customer.model.request.CustomerRequest;
import com.project.bank.customer.model.response.CustomerResponse;
import com.project.bank.customer.service.CustomerService;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Observable;
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

    @Override
    public Completable saveCustomer(CustomerRequest customerRequest) {
        return Observable.just(customerRequest)
                .map(customerMapper::buildCustomerEntityFromCustomerRequest)
                .flatMapCompletable(customerDao::saveCustomer)
                .doOnError(error ->
                        log.error("Error saving customer: {}", error.getMessage(), error))
                .doOnComplete(() -> log.info("Customer saved successfully"));
    }

    @Override
    public Completable deleteCustomerById(String id) {
        return customerDao.getCustomerById(id)
                .switchIfEmpty(Observable.error(
                        new NotFoundException("Customer with id " + id + " not found")))
                .flatMapCompletable(customer -> customerDao.deleteCustomerById(id))
                .doOnComplete(() -> log.info("Customer deleted successfully"))
                .doOnError(error ->
                        log.error("Error deleting customer: {}", error.getMessage(), error));
    }
}
