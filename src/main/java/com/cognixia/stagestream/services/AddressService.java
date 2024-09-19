package com.cognixia.stagestream.services;

import java.util.List;

import com.cognixia.stagestream.models.Address;
import com.cognixia.stagestream.dto.AddressDTO;

public interface AddressService {
	
	AddressDTO createAddress(AddressDTO addressDTO);
	
	List<AddressDTO> getAddresses();
	
	AddressDTO getAddress(Long addressId);
	
	AddressDTO updateAddress(Long addressId, Address address);
	
	String deleteAddress(Long addressId);
}