package com.alquimiasoft.invoiceservice.service;

import com.alquimiasoft.invoiceservice.entity.Address;
import com.alquimiasoft.invoiceservice.repository.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    IAddressRepository addressRepository;

    public Address saveAddress(Address address){
        return addressRepository.save(address);
    }
}
