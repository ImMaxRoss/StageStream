package com.cognixia.stagestream.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @NotBlank
    private String street;
    
    @NotBlank
    private String city;
    
    @NotBlank
    @Size(min = 2, max = 2, message = "State name must be 2 letters.")
    private String state;
    
    
    @NotBlank
    @Size(min = 5, max = 5,message = "Zipcode must be 5 digits")
    private String zipcode;

    @ManyToMany(mappedBy = "addresses")
    private List<User> users = new ArrayList<>();

    public Address(String state, String city, String zipcode, String street) {
        this.state = state;
        this.city = city;
        this.zipcode = zipcode;
        this.street = street;
    }

}