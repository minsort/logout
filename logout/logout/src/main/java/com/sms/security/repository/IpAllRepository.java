package com.sms.security.repository;

import com.sms.security.model.forUsers.IpAll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IpAllRepository extends JpaRepository<IpAll, String>{
}
