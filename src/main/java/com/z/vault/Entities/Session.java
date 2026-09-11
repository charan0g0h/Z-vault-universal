package com.z.vault.Entities;


import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "sessions")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String sessionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consent_id", nullable = false)
    private Consent consent;

    private String status;

    private OffsetDateTime dataFrom;
    private OffsetDateTime dataTo;

    private String format;

    private OffsetDateTime createdAt;
    private OffsetDateTime completedAt;
    private OffsetDateTime lastFetchedAt;
}