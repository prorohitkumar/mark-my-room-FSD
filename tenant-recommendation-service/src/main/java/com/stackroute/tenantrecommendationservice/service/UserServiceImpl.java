package com.stackroute.tenantrecommendationservice.service;

import com.stackroute.tenantrecommendationservice.model.City;
import com.stackroute.tenantrecommendationservice.model.User;
import com.stackroute.tenantrecommendationservice.repository.CityRepository;
import com.stackroute.tenantrecommendationservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private CityRepository cityRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, CityRepository cityRepository) {
        this.userRepository=userRepository;
        this.cityRepository=cityRepository;
    }

    @Override
    public String createUserNode(User user)  {
        String name=user.getName();
        List<User> users=userRepository.findUserByName(name);
        if(users.size()==0){
            userRepository.save(user);
            createUserCityRelation(name,user.getCity());
            return "User node created";
        } else{
            return "User already exist";
        }
    }


    public void createUserCityRelation(String name, String cityName){
        List<City> cities=cityRepository.findCity(cityName);
        if(cities.size()==0){
            City cityNode=new City();
            cityNode.setCityName(cityName);
            cityRepository.save(cityNode);
        }
        userRepository.createUserLocationRelationship(name, cityName);
    }

   @Override
    public List<User> generateRecommendationByGender(String name) {
        return userRepository.getRecommendedUserByGender(name);
    }

    @Override
    public List<User> generateRecommendationByCity(String name) {
        return userRepository.getRecommendedUserByCity(name);
    }

    @Override
    public List<User> generateRecommendationBySmokingHabit(String name) {
        return userRepository.getRecommendedUserBySmokingHabit(name);
    }

    @Override
    public List<User> generateRecommendationByAgeGroup(String name) {
        return userRepository.getRecommendedUserByAgeGroup(name);
    }

    @Override
    public List<User> generateRecommendation(String name) {
        return userRepository.getRecommendedUser(name);
    }
}
