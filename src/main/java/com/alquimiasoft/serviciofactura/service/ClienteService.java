package com.alquimiasoft.serviciofactura.service;

import com.alquimiasoft.serviciofactura.entity.Cliente;
import com.alquimiasoft.serviciofactura.repository.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ICliente clienteRepository;

    public Cliente crearCliente(Cliente nuevoCliente) {
        return clienteRepository.save(nuevoCliente);
    }

    public List<Cliente> obtenerClientes(){
        return clienteRepository.findAll();
    }

    public Cliente buscarCliente(Long id){
        return clienteRepository.findById(id).orElse(null);
    }

    public void eliminarCliente(Long id){
        clienteRepository.deleteById(id);
    }

}
