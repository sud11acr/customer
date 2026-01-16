package com.project.bank.customer.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customers")
public class Customer {
    @Id
    private String id;
    private String name;
    private String lastName;
    private String documentNumber;
    private String documentType;
    private String customerType;
    private LocalDate birthDate;
    private Map<String,String> products;
    private LocalDate registrationDate;
    private LocalDate modificationDate;
    private boolean status;
}
