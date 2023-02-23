package com.example.cryptoxcnange.model.currency;

import com.example.cryptoxcnange.model.wallet.Wallet;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "currencies")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class Currency  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "currency_id")
    private long id;

    @Column(name = "currency_names")
    private String name;

    @Column(name = "denominations")
    private final int denomination = 1;

    @Column(name = "price")
    private double price;

    @Column(name = "balance")
    private double balance;

    @ManyToOne
    @JoinColumn(name = "wallet_id",referencedColumnName = "id")
    private Wallet wallet;




}
