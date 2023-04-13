package com.stackroute.propertyownerservice.controller;

import com.google.gson.Gson;
import com.stackroute.propertyownerservice.domain.PropertyDetails;
import com.stackroute.propertyownerservice.exception.PropertyDetailsAlreadyExistsException;
import com.stackroute.propertyownerservice.exception.PropertyNotFoundException;
import com.stackroute.propertyownerservice.repository.PropertyOwnerRepository;
import com.stackroute.propertyownerservice.service.PropertyOwnerService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
@Slf4j
@RestController
@RequestMapping("api/v1")

public class PropertyOwnerController {
    private PropertyOwnerService propertyOwnerService;
    private ResponseEntity responseEntity;

    @Autowired
   public PropertyOwnerController(PropertyOwnerService propertyOwnerService) {
        this.propertyOwnerService = propertyOwnerService;
    }

    @GetMapping("/properties")
    public ResponseEntity<?> getAllPropertyDetails(){
        return new ResponseEntity<>(propertyOwnerService.getAllPropertyDetails(), HttpStatus.OK);
    }

    @PostMapping("/property")
    public ResponseEntity<?> registerProperty(@RequestParam ("propertyDetails")String propertyDetails, @RequestParam("file") MultipartFile multipartFile) throws PropertyDetailsAlreadyExistsException, IOException {
//        return new ResponseEntity<>(propertyOwnerService.registerProperty(propertyDetails,file),HttpStatus.CREATED);
        Gson gson=new Gson();
        PropertyDetails propertyDetailsObj=gson.fromJson(propertyDetails,PropertyDetails.class);
        try {

            PropertyDetails registeredProperty=propertyOwnerService.registerProperty(propertyDetailsObj, multipartFile);
            responseEntity=new ResponseEntity<>(registeredProperty, HttpStatus.CREATED);
        } catch (PropertyDetailsAlreadyExistsException e){

            log.error("error"+e.getMessage());

            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }catch (Exception a){
            log.error("error"+a.getMessage());
            responseEntity = new ResponseEntity<>(a.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
    @PutMapping("/updatePropertyDetails")
    public ResponseEntity<?> updatePropertyDetails(@RequestBody PropertyDetails propertyDetails) throws PropertyNotFoundException{

        return new ResponseEntity<>(propertyOwnerService.updatePropertyDetails(propertyDetails),HttpStatus.FOUND);
    }

    @DeleteMapping("/deleteProperty/{id}")
    public String deleteProperty(@PathVariable String id) {
        propertyOwnerService.deleteProperty(id);
        return "Property Details deleted successfully";
    }

    @GetMapping("/getAllPropertyByLocation/{location}")
    public ResponseEntity<?> getAllPropertyByLocation(@PathVariable String location) throws PropertyNotFoundException{
        return new ResponseEntity<>(propertyOwnerService.getAllPropertyByLocation(location),HttpStatus.OK);
    }

    @GetMapping("/getAllPropertyByFurnishingType/{furnishingType}")
    public ResponseEntity<?> getAllPropertyByFurnishingType(@PathVariable String furnishingType) throws PropertyNotFoundException{
        return new ResponseEntity<>(propertyOwnerService.getAllPropertyByFurnishingType(furnishingType),HttpStatus.OK);
    }

    @GetMapping("/getAllPropertyByPreferredTenants/{preferredTenants}")
    public ResponseEntity<?> getAllPropertyByPreferredTenants(@PathVariable String preferredTenants) throws PropertyNotFoundException{
        return new ResponseEntity<>(propertyOwnerService.getAllPropertyByPreferredTenants(preferredTenants),HttpStatus.OK);
    }

    @GetMapping("/getAllPropertyByPropertyType/{propertyType}")
    public ResponseEntity<?> getAllPropertyByPropertyType(@PathVariable String propertyType) throws PropertyNotFoundException{
        return new ResponseEntity<>(propertyOwnerService.getAllPropertyByPropertyType(propertyType),HttpStatus.OK);
    }
}
