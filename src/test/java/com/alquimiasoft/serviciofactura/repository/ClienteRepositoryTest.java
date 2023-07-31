package com.alquimiasoft.serviciofactura.repository;

import com.alquimiasoft.serviciofactura.entity.Cliente;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;

@DataJpaTest
@Transactional
public class ClienteRepositoryTest {

    @Autowired
    private IClienteRepository clienteRepository;

    @Test
    void testGuardarCliente(){
        // Given
        /*Cliente cliente = Cliente.builder()
                .tipoIdentificacion("RUC")
                .identificacion("05123558411")
                .nombre("Paul Ramon")
                .correo("peramon@utpl.edu.ec")
                .numeroCelular("10256941210")
                .build();
        System.out.println(cliente.getNombre());*/

      /*  // When
        Cliente clienteGuardado = clienteRepository.save(cliente);

        // Then
        Assertions.assertThat(clienteGuardado).isNotNull();
        Assertions.assertThat(clienteGuardado.getId()).isGreaterThan(0);*/
    }

}
