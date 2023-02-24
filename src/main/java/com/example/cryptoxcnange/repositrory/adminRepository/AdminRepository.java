package com.example.cryptoxcnange.repositrory.adminRepository;

import com.example.cryptoxcnange.model.role.Trader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Trader.Admin,Long> {
}
