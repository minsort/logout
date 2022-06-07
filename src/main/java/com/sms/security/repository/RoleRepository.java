package com.sms.security.repository;

import com.sms.security.model.forUsers.ERole;
import com.sms.security.model.forUsers.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
