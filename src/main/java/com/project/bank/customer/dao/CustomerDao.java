package com.project.bank.customer.dao;

import com.project.bank.customer.model.entity.Customer;
import io.reactivex.Completable;
import io.reactivex.Observable;

public interface CustomerDao {
    Observable<Customer> getAllCustomers();
    Observable<Customer> getCustomerById(String id);
    Completable saveCustomer(Customer customer);
    Completable deleteCustomerById(String id);
}
