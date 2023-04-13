package com.stackroute.tenantrecommendationservice.controller;

import com.stackroute.tenantrecommendationservice.model.User;
import com.stackroute.tenantrecommendationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUserNode(user), HttpStatus.OK);
    }

    @GetMapping("/recommendByGender")
    public ResponseEntity<?> getRecommendedUserByGender(@RequestParam String name){
        return new ResponseEntity<>(userService.generateRecommendationByGender(name), HttpStatus.OK);
    }

    @GetMapping("/recommendByCity")
    public ResponseEntity<?> getRecommendedUserByCity(@RequestParam String name){
        return new ResponseEntity<>(userService.generateRecommendationByCity(name), HttpStatus.OK);
    }

    @GetMapping("/recommendBySmoking")
    public ResponseEntity<?> getRecommendedUserBySmokingHabit(@RequestParam String name){
        return new ResponseEntity<>(userService.generateRecommendationBySmokingHabit(name), HttpStatus.OK);
    }

    @GetMapping("/recommendByAge")
    public ResponseEntity<?> getRecommendedUserByAgeGroup(@RequestParam String name){
        return new ResponseEntity<>(userService.generateRecommendationByAgeGroup(name), HttpStatus.OK);
    }

    @GetMapping("/recommend")
    public ResponseEntity<?> getRecommendedUser(@RequestParam String name){
        return new ResponseEntity<>(userService.generateRecommendation(name), HttpStatus.OK);
    }
}
