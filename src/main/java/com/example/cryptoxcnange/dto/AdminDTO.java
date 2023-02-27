package com.example.cryptoxcnange.dto;

import com.example.cryptoxcnange.model.currency.Currency;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDTO {
    private String secret;
    private Currency currency;
}
