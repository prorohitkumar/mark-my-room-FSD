package com.stackroute.tenantservice.repository;

import com.stackroute.tenantservice.model.Tenant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TenantRepository extends MongoRepository<Tenant,String> {
    Optional<Tenant> findById(String id);
    Optional<Tenant> findByEmail(String email);
}
