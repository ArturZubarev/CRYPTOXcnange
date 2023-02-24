package com.example.cryptoxcnange.model.secretKey;

import com.example.cryptoxcnange.model.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "secret_keys")
@AllArgsConstructor
@NoArgsConstructor
public class SecretKey {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    public long secretKey(){
        long secret = 21 * 31 + (user.hashCode());
        System.out.println(secret);
        return secret;
    }
}
