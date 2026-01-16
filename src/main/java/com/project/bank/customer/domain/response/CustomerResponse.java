package com.project.bank.customer.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResponse {
    private String id;
    private String name;
    private String lastName;
    private String documentNumber;
    private String documentType;
    private String customerType;
    private LocalDate birthDate;
    private boolean status;
}
