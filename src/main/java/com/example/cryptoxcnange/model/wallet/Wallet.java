package com.example.cryptoxcnange.model.wallet;

import com.example.cryptoxcnange.model.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
@Getter
@Setter

public class Wallet {
    @Id
    @Column(name = "wallet_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "currencyName")
    private String currencyName;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "createdAt")
    private LocalDateTime created_at;

    @Column(name = "total_cost")
    private Double totalCost;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User walletOwner;


}
