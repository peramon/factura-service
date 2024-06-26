package com.alquimiasoft.invoiceservice.service;

import com.alquimiasoft.invoiceservice.entity.Customer;
import com.alquimiasoft.invoiceservice.exception.ResourceNotFoundException;
import com.alquimiasoft.invoiceservice.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    ICustomerRepository customerRepository;


    public Customer createCustomer(Customer newCustomer) {
        Optional<Customer> saveCustomer = Optional.ofNullable(customerRepository.searchByIdentification(newCustomer.getIdentification()));

        if(saveCustomer.isPresent()){
            throw new ResourceNotFoundException("The customer already exists in the database: " + newCustomer.getIdentification());
        }
        if(newCustomer.getIdentification().length() == 10){
            return customerRepository.save(newCustomer);
        }else{
            throw new ResourceNotFoundException("The customer has to enter the 10 digits in the customer identification");
        }

        // TODO controls for number phone and email
    }

    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    public Customer searchCustomerById(Integer id){
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public void deleteCustomer(Integer id){
        customerRepository.deleteById(id);
    }

    public List<Map<String, String>> getAddressList(Integer id){
        return customerRepository.getInformation(id);
    }

    // Service to search customers by identification
    public Customer searchCustomerByIdentification(String identification){
        return customerRepository.searchByIdentification(identification);
    }

    // Service to update customer information
    public Customer updateCustomer(Customer customer){
        return customerRepository.save(customer);
    }
}
