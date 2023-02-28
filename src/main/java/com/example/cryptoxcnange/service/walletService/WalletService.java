package com.example.cryptoxcnange.service.walletService;

import com.example.cryptoxcnange.model.user.User;
import com.example.cryptoxcnange.model.wallet.Wallet;
import com.example.cryptoxcnange.repositrory.walletRepository.WalletRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WalletService {
    private final WalletRepository walletRepository;


    public User findByUser(String secret) {
        return walletRepository.findWalletByWalletOwner(secret);
    }

    public void save(Wallet wallet){
        walletRepository.save(wallet);
    }



}
