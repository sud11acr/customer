package com.project.bank.customer.service;

import com.project.bank.customer.model.response.CustomerResponse;
import io.reactivex.Flowable;

public interface CustomerService {
    Flowable<CustomerResponse> getAllCustomers();
}
