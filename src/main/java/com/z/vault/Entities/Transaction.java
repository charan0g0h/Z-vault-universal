package com.z.vault.Entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(
        name = "transactions",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_account_txn",
                        columnNames = {"bank_account_id", "txn_id"}
                )
        },
        indexes = {
                @Index(
                        name = "idx_transaction_account",
                        columnList = "bank_account_id"
                ),
                @Index(
                        name = "idx_transaction_timestamp",
                        columnList = "transaction_timestamp"
                ),
                @Index(
                        name = "idx_transaction_counterparty",
                        columnList = "counterparty"
                )
        }
)
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_account_id", nullable = false)
    private BankAccount bankAccount;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal amount;

    @Column(precision = 19, scale = 2)
    private BigDecimal currentBalance;

    private String mode;

    @Column(length = 1000)
    private String narration;

    private String reference;

    @Column(name = "txn_id", nullable = false)
    private String txnId;

    private String type;

    private OffsetDateTime transactionTimestamp;

    private LocalDate valueDate;

    private String counterparty;

    // ML features

    private Integer hour;

    private Double freqPerWeek;

    @Column(precision = 19, scale = 2)
    private BigDecimal avgAmountCounterparty;

    private Integer transactionCountCounterparty;

    private Integer daysSinceLastTransaction;

    private String predictedCategory;
}