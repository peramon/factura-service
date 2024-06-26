package com.alquimiasoft.invoiceservice.controller;

import static org.hamcrest.CoreMatchers.is;

import static org.mockito.ArgumentMatchers.any;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import com.alquimiasoft.invoiceservice.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest // Para probar los controladores
public class InvoiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean // Para agregaqr objetos simulados al contexto de la aplicacion
    private CustomerService customerService;

    @Autowired
    private ObjectMapper objectMapper;



    // TODO Review this test

}
