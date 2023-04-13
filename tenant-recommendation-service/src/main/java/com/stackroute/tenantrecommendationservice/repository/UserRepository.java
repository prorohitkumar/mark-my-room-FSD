package com.stackroute.tenantrecommendationservice.repository;

import com.stackroute.tenantrecommendationservice.model.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends Neo4jRepository<User, Long> {

    @Query("MATCH(u:User {name:$name}) RETURN u")
    List<User> findUserByName(String name);

    @Query("MATCH(u:User {name:$name}),(c:City {cityName:$cityName}) CREATE(u)-[:from]->(c)")
    void createUserLocationRelationship(String name, String cityName);

    @Query("MATCH(u1:User {name:$name})-[:from]->(:City)<-[:from]-(u2:User) return u2")
    List<User> getRecommendedUserByCity(String name);

    @Query("MATCH(u1:User {name:$name})-[:from]->(:City)<-[:from]-(u2:User) where u2.gender=u1.gender return u2")
    List<User> getRecommendedUserByGender(String name);

    @Query("MATCH(u1:User {name:$name})-[:from]->(:City)<-[:from]-(u2:User) where u2.smoker=u1.smoker AND u2.gender=u1.gender return u2")
    List<User> getRecommendedUserBySmokingHabit(String name);

    @Query("MATCH(u1:User {name:$name})-[:from]->(:City)<-[:from]-(u2:User) where u2.ageGroup=u1.ageGroup AND u2.gender=u1.gender return u2")
    List<User> getRecommendedUserByAgeGroup(String name);

    @Query("MATCH(u1:User {name:$name})-[:from]->(:City)<-[:from]-(u2:User) where u2.ageGroup=u1.ageGroup AND u2.gender=u1.gender AND u2.smoker=u1.smoker return u2")
    List<User> getRecommendedUser(String name);
}
