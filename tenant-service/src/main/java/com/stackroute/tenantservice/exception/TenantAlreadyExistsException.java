package com.stackroute.tenantservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.CONFLICT,reason="Specified Tenant Details Already Exists")
public class TenantAlreadyExistsException extends Exception{
}
