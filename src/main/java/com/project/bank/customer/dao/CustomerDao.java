package com.project.bank.customer.dao;

import com.project.bank.customer.model.entity.Customer;
import io.reactivex.Completable;
import io.reactivex.Observable;

public interface CustomerDao {
    Observable<Customer> getAllCustomers();
    Completable saveCustomer(Customer customer);
}
