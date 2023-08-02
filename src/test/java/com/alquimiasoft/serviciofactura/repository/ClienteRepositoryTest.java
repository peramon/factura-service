package com.alquimiasoft.serviciofactura.repository;

import com.alquimiasoft.serviciofactura.entity.Cliente;
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
public class ClienteRepositoryTest {

    @Autowired
    private IClienteRepository clienteRepository;

    @DisplayName("Test para guardar un cliente")
    @Test
    // @Rollback(false) //Para que no se revierta la insercion a la base
    void testCrearCliente(){
        // given
        Cliente cliente = Cliente.builder()
                .tipoIdentificacion("RUC")
                .identificacion("1900856345001")
                .nombre("Paul Ramon")
                .correo("peramon@utpl.edu.ec")
                .numeroCelular("0994308765")
                .build();
        System.out.println(cliente.getNombre());

        // when
        Cliente clienteGuardado = clienteRepository.save(cliente);

        // then
        assertThat(clienteGuardado).isNotNull();
        assertThat(clienteGuardado.getId()).isGreaterThan(0);
    }

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
    @DisplayName("Test para listar los clientes")
    @Test
    void testObtenerClientes(){
        // given
        Cliente clienteUno = Cliente.builder()
                .tipoIdentificacion("Cedula")
                .identificacion("1200987345")
                .nombre("Julio Jaramillo")
                .correo("julio@utpl.edu.ec")
                .numeroCelular("0994593929")
                .build();
        clienteRepository.save(this.cliente); // Cliente a nivel global
        clienteRepository.save(clienteUno);

        // when
        List<Cliente> listaClientes = clienteRepository.findAll();

        // then
        assertThat(listaClientes).isNotNull();
        // assertThat(listaClientes.size()).isEqualTo(4); Falla
        assertThat(listaClientes.size()).isEqualTo(2);
    }

    @DisplayName("Test para buscar un cliente por ID")
    @Test
    void testBuscarCliente(){
        // given
        clienteRepository.save(this.cliente);

        // when
        Cliente clienteBD = clienteRepository.findById(cliente.getId()).get();

        // then
        assertThat(clienteBD).isNotNull();


    }

    @DisplayName("Test para actualizar un cliente por ID")
    @Test
    void testActualizarCliente(){
        // given
        clienteRepository.save(this.cliente);

        // when
        Cliente clienteGuardado = clienteRepository.findById(this.cliente.getId()).get();
        clienteGuardado.setCorreo("julio2@utpl.edu.ec");
        clienteGuardado.setTipoIdentificacion("RUC");
        clienteGuardado.setIdentificacion("1300237845001");

        Cliente clienteActualizado = clienteRepository.save(clienteGuardado);

        // then
        // assertThat(clienteActualizado.getCorreo()).isEqualTo("julio@utpl.edu.ec"); Falla
        assertThat(clienteActualizado.getCorreo()).isEqualTo("julio2@utpl.edu.ec");
        assertThat(clienteActualizado.getTipoIdentificacion()).isEqualTo("RUC");
    }

    @DisplayName("Test para eliminar un cliente por ID")
    @Test
    void testEliminarCliente(){
        // given
        clienteRepository.save(this.cliente);

        // when
        clienteRepository.deleteById(this.cliente.getId());
        Optional<Cliente> clienteOp = clienteRepository.findById(this.cliente.getId());

        // then
        assertThat(clienteOp).isEmpty();
    }

    // TODO: Hacer los test de los 2 metodos agregados






}
