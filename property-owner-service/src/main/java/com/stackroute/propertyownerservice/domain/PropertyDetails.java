package com.stackroute.propertyownerservice.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

@Document(indexName = "markmyroom")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PropertyDetails {

    @Id
    private String propertyId;
    private String ownerName;
    private String location;
    private String postedBy;
    private String propertyType;
    private String preferredTenants;
    private String propertyRent;
    private String propertyName;
    private String propertyDescription;
    private List<String> amenities;
    private String furnishingType;
    private String rules;
    private byte[] image;
}
