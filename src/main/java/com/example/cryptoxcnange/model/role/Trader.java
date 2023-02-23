package com.example.cryptoxcnange.model.role;

import com.example.cryptoxcnange.model.wallet.Wallet;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.BatchSize;

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

    @Column(name = "trader_email", nullable = false)
    @Email
    @NotBlank
    private String email;

    @Column(name = "trader_names", nullable = false)
    @Size(min = 3)
    @NotBlank
    private String userName;

    @OneToOne(mappedBy = "trader")
    private Wallet wallet;
}
