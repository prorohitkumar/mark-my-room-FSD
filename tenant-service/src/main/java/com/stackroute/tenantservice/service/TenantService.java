package com.stackroute.tenantservice.service;

import com.stackroute.tenantservice.exception.TenantAlreadyExistsException;
import com.stackroute.tenantservice.exception.TenantDoesNotExistsException;
import com.stackroute.tenantservice.model.Tenant;

public interface TenantService {
  public Tenant addTenant(Tenant tenant) throws TenantAlreadyExistsException;

  public Tenant editProfile(String id) throws TenantDoesNotExistsException;

    public Tenant updateProfile(Tenant tenant);
}
