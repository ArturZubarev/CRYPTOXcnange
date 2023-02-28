package com.example.cryptoxcnange.business.user;

import com.example.cryptoxcnange.dto.user.UserDTOWithSecretKey;
import com.example.cryptoxcnange.model.user.User;
import com.example.cryptoxcnange.model.wallet.Wallet;
import com.example.cryptoxcnange.repositrory.walletRepository.WalletRepository;
import com.example.cryptoxcnange.service.userService.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Component
public class WalletCreator {
    private final UserService userService;

    private final WalletRepository walletRepository;

    public void createWallet(UserDTOWithSecretKey userDTO) {
        String secretKey = userDTO.getSecret();
        User userFromRepository = userService.findUserBySecret(secretKey);

        Set<Wallet> walletSet = new HashSet<>();
        userFromRepository.setWallets(walletSet);

        Wallet wallet = new Wallet();
        wallet.setWalletOwner(userFromRepository);
        wallet.setBalance(userDTO.getBalance());

        walletSet.add(wallet);

        walletRepository.save(wallet);


        }

    }


