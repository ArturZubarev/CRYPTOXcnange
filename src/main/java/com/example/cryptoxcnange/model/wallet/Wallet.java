package com.example.cryptoxcnange.model.wallet;

import com.example.cryptoxcnange.model.currency.Currency;
import com.example.cryptoxcnange.model.role.Trader;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode

public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    @OneToMany(mappedBy = "wallet")
    private Set<Currency> currency;

    @OneToOne
    @JoinColumn
    private Trader trader;




}
