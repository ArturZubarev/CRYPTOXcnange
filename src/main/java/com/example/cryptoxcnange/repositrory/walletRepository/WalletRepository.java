package com.example.cryptoxcnange.repositrory.walletRepository;

import com.example.cryptoxcnange.model.user.User;
import com.example.cryptoxcnange.model.wallet.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet,Long> {
    public User findWalletByWalletOwner(String secret);

}
