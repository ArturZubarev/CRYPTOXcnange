package com.example.cryptoxcnange.business.user;

import com.example.cryptoxcnange.dto.user.UserDTO;
import com.example.cryptoxcnange.dto.user.UserDTOWithSecretKey;
import com.example.cryptoxcnange.model.currency.Currency;
import com.example.cryptoxcnange.model.user.User;
import com.example.cryptoxcnange.model.wallet.Wallet;
import com.example.cryptoxcnange.repositrory.walletRepository.WalletRepository;
import com.example.cryptoxcnange.service.currencyService.CurrencyService;
import com.example.cryptoxcnange.service.userService.UserService;
import com.example.cryptoxcnange.service.walletService.WalletService;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Component
public class WalletCreator {
    private final UserService userService;
    private final CurrencyService currencyService;
    private final WalletService walletService;
    private final WalletRepository walletRepository;

    public void createWallet(UserDTOWithSecretKey userDTO) {





        }

    }


