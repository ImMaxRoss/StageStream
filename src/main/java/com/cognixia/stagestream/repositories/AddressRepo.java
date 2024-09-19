package com.cognixia.stagestream.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cognixia.stagestream.models.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {
    
    Address findByStateAndCityAndZipcodeAndStreet(String state, String city, String zipcode, String street);
}