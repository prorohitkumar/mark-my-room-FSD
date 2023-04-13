package com.stackroute.propertyownerservice.service;

import com.stackroute.propertyownerservice.domain.PropertyDetails;
import com.stackroute.propertyownerservice.exception.PropertyDetailsAlreadyExistsException;
import com.stackroute.propertyownerservice.exception.PropertyNotFoundException;
import com.stackroute.propertyownerservice.repository.PropertyOwnerRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PropertyOwnerServiceImpl implements PropertyOwnerService {

    private PropertyOwnerRepository propertyOwnerRepository;
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    public PropertyOwnerServiceImpl(PropertyOwnerRepository propertyOwnerRepository, ElasticsearchRestTemplate elasticsearchRestTemplate) {
        this.propertyOwnerRepository = propertyOwnerRepository;
        this.elasticsearchRestTemplate = elasticsearchRestTemplate;
    }

    @Override
    public PropertyDetails registerProperty(PropertyDetails propertyDetails, MultipartFile file) throws PropertyDetailsAlreadyExistsException, IOException {

        PropertyDetails registeredProperty = new PropertyDetails();
        Optional<PropertyDetails> registerProperty = propertyOwnerRepository.findById(propertyDetails.getPropertyId());
        if(registerProperty.isPresent())
        {
//            log.error("Property is already present");
            throw new PropertyDetailsAlreadyExistsException();
        }else {
            propertyDetails.setImage(file.getBytes());
            registeredProperty = propertyOwnerRepository.save(propertyDetails);
            return registeredProperty;
        }
    }

    @Override
    public void deleteProperty(String id) {
        propertyOwnerRepository.deleteById(id);

    }

    @Override
    public PropertyDetails updatePropertyDetails(PropertyDetails propertyDetails) throws PropertyNotFoundException {
        if (propertyOwnerRepository.findById(propertyDetails.getPropertyId()).isEmpty()) {
            throw new PropertyNotFoundException();
        }
        return propertyOwnerRepository.save(propertyDetails);
    }

    @Override
    public Iterable<PropertyDetails> getAllPropertyDetails() {
        return propertyOwnerRepository.findAll();
    }

    @Override
    public List<PropertyDetails> getAllPropertyByLocation(String location) throws PropertyNotFoundException {
        if (propertyOwnerRepository.findByLocation(location).isEmpty()) {
            throw new PropertyNotFoundException();
        }
        return propertyOwnerRepository.findByLocation(location);
    }


    @Override
    public List<PropertyDetails> getAllPropertyByFurnishingType(String furnishingType) throws PropertyNotFoundException {
        if (propertyOwnerRepository.findByFurnishingType(furnishingType).isEmpty()) {
            throw new PropertyNotFoundException();
        }
        return propertyOwnerRepository.findByFurnishingType(furnishingType);
    }

    @Override
    public List<PropertyDetails> getAllPropertyByPreferredTenants(String preferredTenants) throws PropertyNotFoundException {
        if (propertyOwnerRepository.findByPreferredTenants(preferredTenants).isEmpty()) {
            throw new PropertyNotFoundException();
        }
        return propertyOwnerRepository.findByPreferredTenants(preferredTenants);
    }

    @Override
    public List<PropertyDetails> getAllPropertyByPropertyType(String propertyType) throws PropertyNotFoundException {
        if (propertyOwnerRepository.findByPropertyType(propertyType).isEmpty()) {
            throw new PropertyNotFoundException();
        }
        return propertyOwnerRepository.findByPropertyType(propertyType);
    }
}
