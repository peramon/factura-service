package com.alquimiasoft.serviciofactura.controller;

import com.alquimiasoft.serviciofactura.entity.Cliente;
import com.alquimiasoft.serviciofactura.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/factura")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    // Medoto Post para guardar los datos del cliente
    @PostMapping("/nuevo")
    public Cliente ingresarCliente(@RequestBody Cliente nuevoCliente){
        return clienteService.crearCliente(nuevoCliente);
    }


}
