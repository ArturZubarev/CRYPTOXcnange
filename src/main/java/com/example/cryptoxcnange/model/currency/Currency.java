package com.example.cryptoxcnange.model.currency;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;


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
