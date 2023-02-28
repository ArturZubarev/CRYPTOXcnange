package com.example.cryptoxcnange.dto.currency;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Component
@Getter
@Setter
@NoArgsConstructor

public class CurrencyDTO {
    private String currencyName;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Double price;

}
