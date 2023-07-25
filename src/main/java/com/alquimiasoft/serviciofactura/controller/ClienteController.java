package com.alquimiasoft.serviciofactura.controller;

import com.alquimiasoft.serviciofactura.entity.Cliente;
import com.alquimiasoft.serviciofactura.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // Metodo para obtener el listado de clientes
    @GetMapping("/clientes")
    public List<Cliente> listarClientes(){
        return clienteService.obtenerClientes();
    }

    // Metodo para actualizar la informacion del cliente
    @PutMapping("/cliente/{id}")
    public Cliente actualizarCliente(@PathVariable long id, @RequestBody Cliente cliente){
        Cliente datosCliente = clienteService.buscarCliente(id);
        datosCliente.setTipoIdentificacion(cliente.getTipoIdentificacion());
        datosCliente.setIdentificacion(cliente.getIdentificacion());
        datosCliente.setNombre(cliente.getNombre());
        datosCliente.setCorreo(cliente.getCorreo());
        datosCliente.setNumeroCelular(cliente.getNumeroCelular());
        datosCliente.setDireccion(cliente.getDireccion());
        return clienteService.crearCliente(datosCliente);
    }
}

/*private String tipoIdentificacion;
    private String identificacion;
    private String nombre;
    private String correo;
    private String numeroCelular;
    private String direccion;
*/
