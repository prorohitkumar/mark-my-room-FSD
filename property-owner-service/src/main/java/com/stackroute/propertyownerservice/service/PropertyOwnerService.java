package com.stackroute.propertyownerservice.service;

import com.stackroute.propertyownerservice.domain.PropertyDetails;
import com.stackroute.propertyownerservice.exception.PropertyDetailsAlreadyExistsException;
import com.stackroute.propertyownerservice.exception.PropertyNotFoundException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface PropertyOwnerService {
    PropertyDetails registerProperty(PropertyDetails propertyDetails, MultipartFile file) throws PropertyDetailsAlreadyExistsException, IOException;
    void deleteProperty(String id) ;
    PropertyDetails updatePropertyDetails(PropertyDetails propertyDetails) throws PropertyNotFoundException;

    Iterable<PropertyDetails> getAllPropertyDetails();
    List<PropertyDetails> getAllPropertyByLocation(String location) throws PropertyNotFoundException;
    List<PropertyDetails> getAllPropertyByFurnishingType(String furnishingType) throws PropertyNotFoundException;
    List<PropertyDetails> getAllPropertyByPreferredTenants(String preferredTenants) throws PropertyNotFoundException;
    List<PropertyDetails> getAllPropertyByPropertyType(String propertyType) throws PropertyNotFoundException;


}
