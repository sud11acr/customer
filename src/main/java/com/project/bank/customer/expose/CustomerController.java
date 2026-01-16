package com.project.bank.customer.expose;

import com.project.bank.customer.model.request.CustomerRequest;
import com.project.bank.customer.model.response.CustomerResponse;
import com.project.bank.customer.service.CustomerService;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("v1/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public Maybe<ResponseEntity<Flowable<CustomerResponse>>> getAllCustomers() {
        log.info("Begin getAllCustomers - CustomerController");
        return Maybe.just(ResponseEntity.ok(customerService.getAllCustomers()))
                .doOnSuccess(response ->
                        log.info("End getAllCustomers - CustomerController"))
                .doOnError(error ->
                        log.error("Error in getAllCustomers - {}", error.getMessage(), error));
    }

    @PostMapping
    public Maybe<ResponseEntity<Void>> saveCustomer(@RequestBody CustomerRequest customerRequest) {
        log.info("Begin saveCustomer");
        return customerService.saveCustomer(customerRequest)
                .andThen(Maybe.just(ResponseEntity.created(URI.create("")).<Void>build()))
                .doOnSuccess(response ->
                        log.info("End saveCustomer - CustomerController"))
                .doOnError(error ->
                        log.error("Error in saveCustomer - {}", error.getMessage(), error));
    }

    @DeleteMapping("/{id}")
    public Maybe<ResponseEntity<Void>> deleteCustomer(@PathVariable String id) {
        log.info("Begin deleteCustomer");
        return customerService.deleteCustomerById(id)
                .andThen(Maybe.just(ResponseEntity.noContent().<Void>build()))
                .onErrorResumeNext(Maybe.just(ResponseEntity.notFound().build()))
                .doOnSuccess(response ->
                        log.info("End deleteCustomer - CustomerController"))
                .doOnError(error ->
                        log.error("Error in deleteCustomer - {}", error.getMessage(), error));
    }
}
