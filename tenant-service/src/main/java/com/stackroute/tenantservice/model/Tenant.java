package com.stackroute.tenantservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "Tenant")
@Entity
public class Tenant {
  @Id
  private String id;
  private String email;
  private String firstName;
  private String lastName ;
  private int age;
  private String gender;
  private String phoneNo ;
  private String address;
  private int pincode;
  private String city;
  private String state;
  private String country;
  private String qualification;
  private String maritalStatus;
  private String occupation;
  private List<String> hobbies;
  private List<String> dislikes;

}
