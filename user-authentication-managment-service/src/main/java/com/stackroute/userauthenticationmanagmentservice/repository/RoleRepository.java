package com.stackroute.userauthenticationmanagmentservice.repository;

import com.stackroute.userauthenticationmanagmentservice.entity.Role;
import com.stackroute.userauthenticationmanagmentservice.entity.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleEnum name);
}