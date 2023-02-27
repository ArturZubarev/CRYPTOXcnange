package com.example.cryptoxcnange.model.wallet;

import com.example.cryptoxcnange.model.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Wallet {
    @Id
    @Column(name = "wallet_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @OneToOne(mappedBy = "wallet")

    private User user;
}
