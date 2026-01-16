package com.project.bank.customer.domain.proxy.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {
    private String id;
    private String description;
    private String productType;
    private BigDecimal maintenanceCost;
    private BigDecimal interestRate;
    private BigDecimal maximumLimitCredit;
    private LocalDate dayFixedTerm;
    private int maximumMovements;
    private BigDecimal balance;
    private BigDecimal commission;
}
