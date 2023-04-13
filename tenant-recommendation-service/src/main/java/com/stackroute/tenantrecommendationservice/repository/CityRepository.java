package com.stackroute.tenantrecommendationservice.repository;

import com.stackroute.tenantrecommendationservice.model.City;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends Neo4jRepository<City, Long> {

    @Query("MATCH(c:City {cityName:$cityName}) RETURN c")
    List<City> findCity(String cityName);
}
