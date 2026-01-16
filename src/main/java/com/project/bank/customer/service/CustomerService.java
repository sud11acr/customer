package com.project.bank.customer.service;

import com.project.bank.customer.model.request.CustomerRequest;
import com.project.bank.customer.model.response.CustomerResponse;
import io.reactivex.Completable;
import io.reactivex.Flowable;

public interface CustomerService {
    Flowable<CustomerResponse> getAllCustomers();
    Completable saveCustomer(CustomerRequest customerRequest);
    Completable deleteCustomerById(String id);
}
