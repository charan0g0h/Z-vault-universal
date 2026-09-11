package com.z.vault.Entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "bank_accounts")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @Column(unique = true)
    private String linkedAccRef;

    private String maskedAccNumber;

    private String accountType;

    private String accountVersion;

    private String bankName;

    private String ifsc;

    private String branch;

    @Column(precision = 19, scale = 2)
    private BigDecimal currentBalance;

    @ManyToMany(mappedBy = "bankAccounts")
    private Set<Consent> consents = new HashSet<>();

    @OneToMany(
            mappedBy = "bankAccount",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Transaction> transactions = new ArrayList<>();
}
