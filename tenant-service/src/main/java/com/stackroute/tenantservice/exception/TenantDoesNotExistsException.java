package com.stackroute.tenantservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND,reason = "Specified Tenant Not Found")
public class TenantDoesNotExistsException extends Exception{
}
