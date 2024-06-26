package com.alquimiasoft.invoiceservice.service;

import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.alquimiasoft.invoiceservice.entity.Customer;
import com.alquimiasoft.invoiceservice.repository.ICustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class) // Trabajar con mockito, cargar extensiones de JUnit
public class CustomerServiceTest {

    @Mock
    private ICustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    private Customer customer;

    // Creo un oibjeto cliente antes de lanzar los metodos de test
    @BeforeEach
    void setup() {
        this.customer = Customer.builder()
                .id(1)
                .identification("1300237845")
                .name("Diana Jara")
                .email("diana@utpl.edu.ec")
                .phone_number("0991239806")
                .build();
    }

    @DisplayName("Test para guardar un cliente")
    @Test
    void testSaveCustomer(){
        // given
        given(customerRepository.save(this.customer)).willReturn(this.customer);

        // when
        Customer customerSaved = customerService.createCustomer(this.customer);

        // then
        assertThat(customerSaved).isNotNull();
    }

    @DisplayName("Test para retornar una lista vacia")
    @Test
    void testGetEmptyCustomerCollection(){
        // given
        Customer newCustomer = Customer.builder()
                .identification("1300237845")
                .name("Carlos Jara")
                .email("carlos@utpl.edu.ec")
                .phone_number("0991245576")
                .build();
        given(customerRepository.findAll()).willReturn(Collections.emptyList());

        // when
        List<Customer> customerList = customerService.getCustomers();

        // then
        assertThat(customerList).isEmpty();
        assertThat(customerList.size()).isEqualTo(0);
    }

    @DisplayName("Test para listar los clientes")
    @Test
    void testGetCustomers(){
        // given
        Customer newCustomer = Customer.builder()
                .identification("1300237845")
                .name("Carlos Jara")
                .email("carlos@utpl.edu.ec")
                .phone_number("0991245576")
                .build();
        given(customerRepository.findAll()).willReturn(List.of(this.customer, newCustomer));
        // when
        List<Customer> customers = customerService.getCustomers();

        //then
        assertThat(customers).isNotNull();
        assertThat(customers.size()).isEqualTo(2);
    }
    @DisplayName("Test para buscar un cliente por ID")
    @Test
    void testSearchCustomer(){
        // given
        given(customerRepository.findById(1)).willReturn(Optional.of(this.customer));

        // when
        Customer customerSaved = customerService.searchCustomerById(this.customer.getId());

        // then
        assertThat(customerSaved).isNotNull();

    }

    @DisplayName("Test para actualizar un cliente")
    @Test
    void testUpdateCustomer(){
        // given
        given(customerRepository.save(this.customer)).willReturn(this.customer);
        this.customer.setEmail("diana@utpl.edu.ec");
        this.customer.setIdentification("0991239806");
        // when
        Customer customerUpdated = customerService.updateCustomer(this.customer);

        // then
        assertThat(customerUpdated.getEmail()).isEqualTo("diana@utpl.edu.ec");

    }

    @DisplayName("Test para eliminar un cliente")
    @Test
    void testDeleteCustomer(){
        // given
        int id = 1;
        willDoNothing().given(customerRepository).deleteById(id);

        // when
        customerService.deleteCustomer(id);

        // then
        verify(customerRepository, times(1)).deleteById(id);
    }





    // TODO Terminar las pruebas unitarias de los services y los conrtrollers


}
