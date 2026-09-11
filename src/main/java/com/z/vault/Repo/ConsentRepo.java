package com.z.vault.Repo;

import com.z.vault.Entities.Consent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ConsentRepo extends JpaRepository<Consent , UUID> {
}
