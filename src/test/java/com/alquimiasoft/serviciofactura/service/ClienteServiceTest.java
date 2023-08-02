package com.alquimiasoft.serviciofactura.service;

import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;

import com.alquimiasoft.serviciofactura.entity.Cliente;
import com.alquimiasoft.serviciofactura.repository.IClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class) // Trabajar con mockito, cargar extensiones de JUnit
public class ClienteServiceTest {

    @Mock
    private IClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    private Cliente cliente;

    // Creo un oibjeto cliente antes de lanzar los metodos de test
    @BeforeEach
    void setup() {
        this.cliente = Cliente.builder()
                .tipoIdentificacion("Cedula")
                .identificacion("1300237845")
                .nombre("Diana Jara")
                .correo("diana@utpl.edu.ec")
                .numeroCelular("0991239806")
                .build();
    }

    @DisplayName("Test para guardar un cliente")
    @Test
    void testGuardarCliente(){
        // given
        given(clienteRepository.save(this.cliente)).willReturn(this.cliente);

        // when
        Cliente clienteGuardado = clienteService.crearCliente(this.cliente);

        // then
        assertThat(clienteGuardado).isNotNull();
    }

    
}
