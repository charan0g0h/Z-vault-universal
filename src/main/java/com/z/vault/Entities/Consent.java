package com.z.vault.Entities;


import jakarta.persistence.*;


import java.time.OffsetDateTime;
import java.util.*;

@Entity
@Table(name = "consents")
public class Consent {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @Column(unique = true)
    private String consentId;

    private String status;

    @Column(length = 1000)
    private String consentUrl;

    private OffsetDateTime consentStart;
    private OffsetDateTime consentExpiry;

    private OffsetDateTime dataFrom;
    private OffsetDateTime dataTo;

    private String dataLife;
    private String fetchType;
    private String consentMode;

    @Column(length = 1000)
    private String purpose;

    private String fiuId;

    private OffsetDateTime createdAt;

    @OneToMany(mappedBy = "consent")
    private List<Session> sessions = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "consent_bank_accounts",
            joinColumns = @JoinColumn(name = "consent_id"),
            inverseJoinColumns = @JoinColumn(name = "bank_account_id")
    )
    private Set<BankAccount> bankAccounts = new HashSet<>();
}