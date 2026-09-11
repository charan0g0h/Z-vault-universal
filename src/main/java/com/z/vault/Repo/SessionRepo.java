package com.z.vault.Repo;

import com.z.vault.Entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface SessionRepo extends JpaRepository<Session , UUID> {
}
