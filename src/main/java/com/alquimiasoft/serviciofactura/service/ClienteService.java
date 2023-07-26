package com.alquimiasoft.serviciofactura.service;

import com.alquimiasoft.serviciofactura.entity.Cliente;
import com.alquimiasoft.serviciofactura.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    IClienteRepository clienteRepository;


    public Cliente crearCliente(Cliente nuevoCliente) {
        return clienteRepository.save(nuevoCliente);
    }

    public List<Cliente> obtenerClientes(){
        return clienteRepository.findAll();
    }

    public Cliente buscarCliente(Integer id){
        return clienteRepository.findById(id).orElse(null);
    }

    public void eliminarCliente(Integer id){
        clienteRepository.deleteById(id);
    }

}
