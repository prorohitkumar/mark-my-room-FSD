package com.stackroute.propertyownerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND,reason = "Specified Property Not Found")
public class PropertyNotFoundException extends Exception{
}
