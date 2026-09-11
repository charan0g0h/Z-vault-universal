package com.z.vault.Repo;

import com.z.vault.Entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BankAccountRepo  extends JpaRepository<BankAccount , UUID> {
}
