package com.example.cryptoxcnange.model.user;

import com.example.cryptoxcnange.model.currency.Currency;
import com.example.cryptoxcnange.model.secretKey.SecretKey;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_email", nullable = false,unique = true)
    @Email
    @NotBlank
    private String email;

    @Column(name = "users_names", nullable = false)
    @Size(min = 3)
    @NotBlank
    private String userName;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Currency> currencyList;


    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private SecretKey secretKey;


}
