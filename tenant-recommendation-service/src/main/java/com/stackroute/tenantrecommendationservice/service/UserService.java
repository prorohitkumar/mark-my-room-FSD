package com.stackroute.tenantrecommendationservice.service;

import com.stackroute.tenantrecommendationservice.model.User;

import java.util.List;

public interface UserService {
    String createUserNode(User user);

    List<User> generateRecommendationByGender(String name);

    List<User> generateRecommendationByCity(String name);

    List<User> generateRecommendationBySmokingHabit(String name);

    List<User> generateRecommendationByAgeGroup(String name);

    List<User> generateRecommendation(String name);


}
