package com.example.cryptoxcnange.model.role;

import com.example.cryptoxcnange.model.currency.Currency;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "traders")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Trader {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "trader_email", nullable = false,unique = true)
    @Email
    @NotBlank
    private String email;

    @Column(name = "trader_names", nullable = false)
    @Size(min = 3)
    @NotBlank
    private String userName;

    @OneToMany(mappedBy = "trader",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Currency> currencyList;

    @Entity
    @Table(name = "admins")
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @ToString
    @Getter
    @Setter
    public static class Admin {
        @Id
        @Column(name = "admin_id")
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        private String userName;

        @Column(name = "email",unique = true,nullable = false)
        private String email;


    }
}
