package com.z.vault.Repo;

import com.z.vault.Entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransactionRepo  extends JpaRepository<Transaction , UUID> {
}
