package com.example.cryptoxcnange.model.user;

import com.example.cryptoxcnange.model.currency.Currency;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.CreditCardNumber;

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

    @Column(name = "user_email", nullable = false, unique = true)
    @Email
    @NotBlank
    private String email;

    @Column(name = "users_names", nullable = false,unique = true)
    @Size(min = 3)
    @NotBlank
    private String userName;

    @Column(name = "role")
    private String role;

    @Column(name = "credit_card")
    @CreditCardNumber
    private String CCnumber;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Currency> currencyList;

    @Column(name = "secret")
    private final String secret = String.valueOf((12 * 252 * Math.random()*31));



}



