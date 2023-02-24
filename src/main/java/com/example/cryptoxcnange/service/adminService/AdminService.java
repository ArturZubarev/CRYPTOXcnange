package com.example.cryptoxcnange.service.adminService;

import com.example.cryptoxcnange.model.role.Trader;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AdminService {
    private final AdminService adminService;

    public Optional<Trader.Admin> findAdminById(int id){
        return adminService.findAdminById(id);
    }
}
