package com.alquimiasoft.serviciofactura.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.alquimiasoft.serviciofactura.entity.Cliente;
import com.alquimiasoft.serviciofactura.service.ClienteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest // Para probar los controladores
public class FacturaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean // Para agregaqr objetos simulados al contexto de la aplicacion
    private ClienteService clienteService;

    @Autowired
    private ObjectMapper objectMapper;

    /*@Test
    void testIngresarDatosCliente() throws Exception {
        // given
        Cliente cliente = Cliente.builder()
                .tipoIdentificacion("Cedula")
                .identificacion("1300237845")
                .nombre("Diana Jara")
                .correo("diana@utpl.edu.ec")
                .numeroCelular("0991239806")
                .direcciones(null)
                .build();
        given(clienteService.crearCliente(any(Cliente.class)))
                .willAnswer((invocation) -> invocation.getArgument(0));

        // when
        ResultActions response = mockMvc.perform(post("/factura/nuevo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cliente)));

        // then
        response.andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nombre",is(cliente.getNombre())))
                .andExpect(jsonPath("$.correo",is(cliente.getCorreo())))
                .andExpect(jsonPath("$.identificacion",is(cliente.getIdentificacion())));

    }*/

    /*@Test
    void testListarClientes() throws Exception {
        // given
        List<Cliente> listaClientes = new ArrayList<>();

        listaClientes.add(Cliente.builder()
                .tipoIdentificacion("Cedula")
                .identificacion("1200987345")
                .nombre("Julio Jaramillo")
                .correo("julio@utpl.edu.ec")
                .numeroCelular("0994593929")
                .direcciones(null)
                .build());

        listaClientes.add(Cliente.builder()
                .id(1)
                .tipoIdentificacion("Cedula")
                .identificacion("1300237845")
                .nombre("Diana Jara")
                .correo("diana@utpl.edu.ec")
                .numeroCelular("0991239806")
                .direcciones(null)
                .build());

        listaClientes.add(Cliente.builder()
                .tipoIdentificacion("RUC")
                .identificacion("1300237845")
                .nombre("Carlos Jara")
                .correo("carlos@utpl.edu.ec")
                .numeroCelular("0991245576")
                .direcciones(null)
                .build());

        given(clienteService.obtenerClientes()).willReturn(listaClientes);

        // when
        ResultActions response = mockMvc.perform(get("/factura/clientes"));

        // then
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()",is(listaClientes.size())));

    }*/

    // TODO Review this test

}
