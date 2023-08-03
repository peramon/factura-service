package com.alquimiasoft.serviciofactura.service;

import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.alquimiasoft.serviciofactura.entity.Cliente;
import com.alquimiasoft.serviciofactura.repository.IClienteRepository;
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
                .id(1)
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

    @DisplayName("Test para retornar una lista vacia")
    @Test
    void testObtenerColeccionClientesVacia(){
        // given
        Cliente clienteNuevo = Cliente.builder()
                .tipoIdentificacion("RUC")
                .identificacion("1300237845")
                .nombre("Carlos Jara")
                .correo("carlos@utpl.edu.ec")
                .numeroCelular("0991245576")
                .build();
        given(clienteRepository.findAll()).willReturn(Collections.emptyList());

        // when
        List<Cliente> listaClientes = clienteService.obtenerClientes();

        // then
        assertThat(listaClientes).isEmpty();
        assertThat(listaClientes.size()).isEqualTo(0);
    }

    @DisplayName("Test para listar los clientes")
    @Test
    void testObtenerClientes(){
        // given
        Cliente clienteNuevo = Cliente.builder()
                .tipoIdentificacion("RUC")
                .identificacion("1300237845")
                .nombre("Carlos Jara")
                .correo("carlos@utpl.edu.ec")
                .numeroCelular("0991245576")
                .build();
        given(clienteRepository.findAll()).willReturn(List.of(this.cliente, clienteNuevo));
        // when
        List<Cliente> clientes = clienteService.obtenerClientes();

        //then
        assertThat(clientes).isNotNull();
        assertThat(clientes.size()).isEqualTo(2);
    }
    @DisplayName("Test para buscar un cliente por ID")
    @Test
    void testBuscarCliente(){
        // given
        given(clienteRepository.findById(1)).willReturn(Optional.of(this.cliente));

        // when
        Cliente clienteGuardado = clienteService.buscarClientePorId(this.cliente.getId());

        // then
        assertThat(clienteGuardado).isNotNull();

    }

    @DisplayName("Test para actualizar un cliente")
    @Test
    void testActualizarCliente(){
        // given
        given(clienteRepository.save(this.cliente)).willReturn(this.cliente);
        this.cliente.setCorreo("diana@utpl.edu.ec");
        this.cliente.setTipoIdentificacion("RUC");
        this.cliente.setIdentificacion("0991239806");
        // when
        Cliente clienteActualizado = clienteService.actualizarCliente(this.cliente);

        // then
        assertThat(clienteActualizado.getCorreo()).isEqualTo("diana@utpl.edu.ec");
        assertThat(clienteActualizado.getTipoIdentificacion()).isEqualTo("RUC");
    }

    @DisplayName("Test para eliminar un cliente")
    @Test
    void testEliminarCliente(){
        // given
        int id = 1;
        willDoNothing().given(clienteRepository).deleteById(id);

        // when
        clienteService.eliminarCliente(id);

        // then
        verify(clienteRepository, times(1)).deleteById(id);
    }





    // TODO Terminar las pruebas unitarias de los services y los conrtrollers


}
