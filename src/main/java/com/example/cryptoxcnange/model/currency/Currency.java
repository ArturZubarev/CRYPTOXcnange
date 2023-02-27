package com.example.cryptoxcnange.model.currency;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "currencies")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Component
public class Currency implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "currency_id")
    private long id;

    @Column(name = "currency_names")
    private String name;

    @Column(name = "denominations")
    private final int denomination = 1;

    @Column(name = "price")
    private Double price;

    @Column(name = "base_currency")
    private static Currency base_currency_USD = new Currency(1,"USD",1.00);



}
