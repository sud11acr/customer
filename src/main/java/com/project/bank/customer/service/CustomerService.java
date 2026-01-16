package com.project.bank.customer.service;

import com.project.bank.customer.domain.request.CustomerRequest;
import com.project.bank.customer.domain.response.CustomerResponse;
import io.reactivex.Completable;
import io.reactivex.Flowable;

public interface CustomerService {
    Flowable<CustomerResponse> getAllCustomers();
    Completable saveCustomer(CustomerRequest customerRequest);
}
