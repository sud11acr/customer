package com.project.bank.customer.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "customers")
public class Customer {
    @Id
    private Long id;
    private String name;
    private String lastName;
    private String documentNumber;
    private String documentType;
    private String customerType;
    private LocalDate birthDate;
    private LocalDate registrationDate;
    private LocalDate modificationDate;
    private boolean status;
}
