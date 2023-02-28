package com.example.cryptoxcnange.dto.user;

import com.example.cryptoxcnange.model.wallet.Wallet;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
public class UserDTOWithSecretKey {
    private String secret;
    private String currencyName;
    private Double balance;

}
