package com.project.bank.customer.domain.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRequest {
    private String name;
    private String lastName;
    private String documentNumber;
    private Map<String,String> products;
    private String documentType;
    private String customerType;
    private LocalDate birthDate;
}
