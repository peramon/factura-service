package com.alquimiasoft.invoiceservice.controller;

import com.alquimiasoft.invoiceservice.dto.InvoiceDto;
import com.alquimiasoft.invoiceservice.entity.Customer;
import com.alquimiasoft.invoiceservice.entity.Address;
import com.alquimiasoft.invoiceservice.entity.Invoice;
import com.alquimiasoft.invoiceservice.repository.IInvoiceRepository;
import com.alquimiasoft.invoiceservice.service.CustomerService;
import com.alquimiasoft.invoiceservice.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    AddressService addressService;

    @Autowired
    IInvoiceRepository invoiceService;

//    private static final Logger LOGGER = Logger.getLogger(ClienteService.class.getName());

    // Post method to save customer data
    @PostMapping("/customer/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody InvoiceDto newCustomer){
        return customerService.createCustomer(newCustomer.getCustomer());
    }

    // Method to get customer list
    @GetMapping("/customers/all")
    public List<Customer> listCustomers(){
        return customerService.getCustomers();
    }

    // Method to update customer information
    @PutMapping("/customer/{id}")
    public Customer updateCustomer(@PathVariable Integer id, @RequestBody InvoiceDto infoCustomer){
        Customer dataCustomer = customerService.searchCustomerById(id);
        System.out.println("Customer ->" + dataCustomer.getIdentification());

        // Update data customer
        if(infoCustomer.getCustomer().getIdentification() != null){
            dataCustomer.setIdentification(infoCustomer.getCustomer().getIdentification());
        }
        if(infoCustomer.getCustomer().getName() != null){
            dataCustomer.setName(infoCustomer.getCustomer().getName());
        }
        if(infoCustomer.getCustomer().getEmail() != null){
            dataCustomer.setEmail(infoCustomer.getCustomer().getEmail());
        }
        if(infoCustomer.getCustomer().getPhone_number() != null){
            dataCustomer.setPhone_number(infoCustomer.getCustomer().getPhone_number());
        }
        return customerService.updateCustomer(dataCustomer);
    }

    // Delete data client
    @DeleteMapping("/customer/{id}")
    public HttpStatus deleteCustomer(@PathVariable Integer id){
        customerService.deleteCustomer(id);
        if(customerService.searchCustomerById(id)==null){
            return HttpStatus.NO_CONTENT;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer could not be deleted");
        }
    }

    // Enter more customer addresses
    @PutMapping("customer/{id}/address/")
    public Customer addAnotherAddress(@PathVariable Integer id, @RequestBody Address anotherAddress){
        Customer currentCustomer = customerService.searchCustomerById(id);
        List<Address> addresses = currentCustomer.getAddresses();
        if(addresses.isEmpty()){
            addresses.add(anotherAddress);
            currentCustomer.setAddresses(addresses);
        }else{
            addresses.add(anotherAddress);
            currentCustomer.setAddresses(addresses);
        }
        return  customerService.createCustomer(currentCustomer);
    }

    // Print customers with their addresses
    @GetMapping("/customer/{id}/address")
    public List<Map<String, String>> getAddressesCustomer(@PathVariable Integer id){
        return customerService.getAddressList(id);
    }

    // Search customer by ID
    @GetMapping("/customer")
    public Customer searchCustomerByIdentification(@RequestParam String dni){
        return customerService.searchCustomerByIdentification(dni);
    }

    // Invoice add
    @PostMapping("{customerID}/invoices")
    public Invoice addInvoice(@PathVariable Integer customerID, @RequestBody Invoice invoice){
        Customer customer = customerService.searchCustomerById(customerID);
        customer.addInvoice(invoice);
        return invoiceService.save(invoice);
    }

    @GetMapping("/{customerId}/invoices")
    public List<Invoice> getInvoices(@PathVariable Integer customerId) {
        Customer customer = customerService.searchCustomerById(customerId);
        return new ArrayList<>(customer.getInvoices());
    }
}


