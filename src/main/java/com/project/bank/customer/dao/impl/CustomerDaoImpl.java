package com.project.bank.customer.dao.impl;

import static io.reactivex.schedulers.Schedulers.io;

import com.project.bank.customer.dao.CustomerDao;
import com.project.bank.customer.model.entity.Customer;
import com.project.bank.customer.repository.CustomerRepository;
import io.reactivex.Completable;
import io.reactivex.Observable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.adapter.rxjava.RxJava2Adapter;

@Component
@RequiredArgsConstructor
@Slf4j
public class CustomerDaoImpl implements CustomerDao {
    private final CustomerRepository customerRepository;
    @Override
    public Observable<Customer> getAllCustomers() {
        return RxJava2Adapter.fluxToObservable(customerRepository.findAll())
                .subscribeOn(io())
                .doOnError(error -> log.error("Error fetching customers", error))
                .doOnSubscribe(disposable -> log.info("Fetching all customers from the database"));
    }

    @Override
    public Completable saveCustomer(Customer customer) {
        return RxJava2Adapter.monoToCompletable(customerRepository.save(customer))
                .subscribeOn(io())
                .doOnError(error -> log.error("Error saving customer: {}", customer, error))
                .doOnComplete(() -> log.info("Customer saved successfully: {}", customer));
    }
}
