package com.stackroute.propertyownerservice.repository;

import com.stackroute.propertyownerservice.domain.PropertyDetails;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyOwnerRepository extends ElasticsearchRepository<PropertyDetails,String> {
   List<PropertyDetails> findByLocation(String location);

    List<PropertyDetails> findByFurnishingType(String furnishingType);

    List<PropertyDetails> findByPreferredTenants(String preferredTenants);

    List<PropertyDetails> findByPropertyType(String propertyType);
}
