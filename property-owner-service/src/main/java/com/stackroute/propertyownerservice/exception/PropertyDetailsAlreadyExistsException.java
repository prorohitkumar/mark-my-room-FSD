package com.stackroute.propertyownerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.CONFLICT,reason="Specified Property Details Already Exists")
public class PropertyDetailsAlreadyExistsException extends Exception{
}
