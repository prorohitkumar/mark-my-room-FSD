package com.stackroute.tenantservice.controller;

import com.stackroute.tenantservice.exception.TenantAlreadyExistsException;
import com.stackroute.tenantservice.exception.TenantDoesNotExistsException;
import com.stackroute.tenantservice.model.Tenant;
import com.stackroute.tenantservice.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class ProfileController {
    @Autowired
    private TenantService tenantService;

    @PostMapping("/addTenant")
    public ResponseEntity<?> saveTenant(@RequestBody Tenant tenant) throws TenantAlreadyExistsException {
        return new ResponseEntity(tenantService.addTenant(tenant) , HttpStatus.OK);
    }

    //gives the profile page
    @GetMapping("/profile")
    public ResponseEntity<?> myProfile(Model model){
       return new ResponseEntity<>(model.addAttribute("title","Profile") , HttpStatus.OK);
    }

    //info of user to be edited
    @GetMapping("/editProfile/{id}")
    public ResponseEntity<?> editProfile(@PathVariable String id) throws TenantDoesNotExistsException {
     return  new ResponseEntity<>(tenantService.editProfile(id) , HttpStatus.OK);
    }

    //updates the user profile
    @PutMapping("/updateProfile/{id}")
    public ResponseEntity<?> updateProfile(@PathVariable String id,
                               @RequestBody Tenant tenant)  throws TenantDoesNotExistsException {
        // get tenant fom database by id
       Tenant existingTenant = tenantService.editProfile(id);
        existingTenant.setId(id);
        existingTenant.setFirstName(tenant.getFirstName());
        existingTenant.setLastName(tenant.getLastName());
        existingTenant.setEmail(tenant.getEmail());
        existingTenant.setAge(tenant.getAge());
        existingTenant.setGender(tenant.getGender());
        existingTenant.setPhoneNo(tenant.getPhoneNo());
        existingTenant.setAddress(tenant.getAddress());
        existingTenant.setPincode(tenant.getPincode());
        existingTenant.setCity(tenant.getCity());
        existingTenant.setState(tenant.getState());
        existingTenant.setCountry(tenant.getCountry());
        existingTenant.setQualification(tenant.getQualification());
        existingTenant.setMaritalStatus(tenant.getMaritalStatus());
        existingTenant.setOccupation(tenant.getOccupation());
        existingTenant.setHobbies(tenant.getHobbies());
        existingTenant.setDislikes(tenant.getDislikes());
        // save updated student object
       return new ResponseEntity<>(tenantService.updateProfile(tenant), HttpStatus.ACCEPTED);

    }

}
