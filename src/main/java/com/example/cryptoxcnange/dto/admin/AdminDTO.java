package com.example.cryptoxcnange.dto.admin;

import com.example.cryptoxcnange.model.currency.Currency;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class AdminDTO {
    private String secret;
    private String currency_name;
    private String currency_price;
}
