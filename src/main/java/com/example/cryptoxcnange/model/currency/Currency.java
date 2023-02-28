package com.example.cryptoxcnange.model.currency;


import com.example.cryptoxcnange.model.wallet.Wallet;
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
public class Currency {

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




}
