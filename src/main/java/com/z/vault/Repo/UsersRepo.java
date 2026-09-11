package com.z.vault.Repo;

import com.z.vault.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.UUID;

@Repository
public interface UsersRepo  extends JpaRepository<Users , UUID> {
    Users findByPhoneNo(java.lang.String phoneNo);
}
