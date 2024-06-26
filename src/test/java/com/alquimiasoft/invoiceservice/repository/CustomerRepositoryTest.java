package com.alquimiasoft.invoiceservice.repository;

import com.alquimiasoft.invoiceservice.entity.Customer;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.List;
import java.util.Optional;

@DataJpaTest
// @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) Para ejecutar las operaciones en la base real
public class CustomerRepositoryTest {

    @Autowired
    private ICustomerRepository customerRepository;

    @DisplayName("Test to save a customer")
    @Test
    // @Rollback(false) //Para que no se revierta la insercion a la base
    void testCreateCustomer(){
        // given
        Customer cliente = Customer.builder()
                .identification("1900856345001")
                .name("Paul Ramon")
                .email("peramon@utpl.edu.ec")
                .phone_number("0994308765")
                .build();
        System.out.println(cliente.getName());

        // when
        Customer savedCustomer = customerRepository.save(cliente);

        // then
        assertThat(savedCustomer).isNotNull();
        assertThat(savedCustomer.getId()).isGreaterThan(0);
    }

    private Customer customer;

    // Creo un oibjeto cliente antes de lanzar los metodos de test
    @BeforeEach
    void setup() {
        this.customer = Customer.builder()
                .identification("1300237845")
                .name("Diana Jara")
                .email("diana@utpl.edu.ec")
                .phone_number("0991239806")
                .build();
    }
    @DisplayName("Test to list customers")
    @Test
    void testGetCustomers(){
        // given
        Customer customerOne = Customer.builder()
                .identification("1200987345")
                .name("Julio Jaramillo")
                .email("julio@utpl.edu.ec")
                .phone_number("0994593929")
                .build();
        customerRepository.save(this.customer); // Customer globally
        customerRepository.save(customerOne);

        // when
        List<Customer> customerList = customerRepository.findAll();

        // then
        assertThat(customerList).isNotNull();
        // assertThat(customerList.size()).isEqualTo(4); Falla
        assertThat(customerList.size()).isEqualTo(2);
    }

    @DisplayName("Test to search a customer by ID")
    @Test
    void testSearchCustomer(){
        // given
        customerRepository.save(this.customer);

        // when
        Customer customerBD = customerRepository.findById(customer.getId()).get();

        // then
        assertThat(customerBD).isNotNull();


    }

    @DisplayName("Test to update a customer by ID")
    @Test
    void testUpdateCustomer(){
        // given
        customerRepository.save(this.customer);

        // when
        Customer customerSaved = customerRepository.findById(this.customer.getId()).get();
        customerSaved.setEmail("julio2@utpl.edu.ec");
        customerSaved.setIdentification("1300237845001");

        Customer customerUpdated = customerRepository.save(customerSaved);

        // then
        // assertThat(customerUpdated.getCorreo()).isEqualTo("julio@utpl.edu.ec"); Failed
        assertThat(customerUpdated.getEmail()).isEqualTo("julio2@utpl.edu.ec");
    }

    @DisplayName("Test to delete a customer by ID")
    @Test
    void testDeletedCustomer(){
        // given
        customerRepository.save(this.customer);

        // when
        customerRepository.deleteById(this.customer.getId());
        Optional<Customer> clienteOp = customerRepository.findById(this.customer.getId());

        // then
        assertThat(clienteOp).isEmpty();
    }

    // TODO: Test for the 2 added methods





}
