package com.alquimiasoft.serviciofactura.service;

import com.alquimiasoft.serviciofactura.dto.InfoDireccionDao;
import com.alquimiasoft.serviciofactura.entity.Cliente;
import com.alquimiasoft.serviciofactura.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    public List<Map<String, String>>  obtenerListaDirecciones(Integer id){
        return clienteRepository.getInformation(id);
    }

    // Servicio para buscar clientes por identificacion
    public Cliente buscarCliente(String identificacion){
        return clienteRepository.buscarPorIdentificacion(identificacion);
    }

}
