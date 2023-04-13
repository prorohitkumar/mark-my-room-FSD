package com.stackroute.tenantservice.service;

import com.stackroute.tenantservice.exception.TenantAlreadyExistsException;
import com.stackroute.tenantservice.exception.TenantDoesNotExistsException;
import com.stackroute.tenantservice.model.Tenant;
import com.stackroute.tenantservice.repository.TenantRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TenantServiceImpl implements TenantService{
    @Autowired
    private TenantRepository tenantRepository;
    @Override
    public Tenant addTenant(Tenant tenant) throws TenantAlreadyExistsException{
        final Optional<Tenant> tenantOptional = tenantRepository.findByEmail(tenant.getEmail());
        if(tenantOptional.isPresent()){
            throw new TenantAlreadyExistsException();
        }
        tenant.setId(UUID.randomUUID().toString());
        return tenantRepository.save(tenant);
    }

    @Override
    public Tenant editProfile(String id) throws TenantDoesNotExistsException {
        if(!tenantRepository.existsById(id)){
            throw new TenantDoesNotExistsException();
        }
        return tenantRepository.findById(id).get();
    }

    @Override
    public Tenant updateProfile(Tenant tenant) {
        return tenantRepository.save(tenant);
    }
}
