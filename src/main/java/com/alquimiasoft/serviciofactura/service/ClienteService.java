package com.alquimiasoft.serviciofactura.service;

import com.alquimiasoft.serviciofactura.dto.InfoDireccionDao;
import com.alquimiasoft.serviciofactura.entity.Cliente;
import com.alquimiasoft.serviciofactura.exception.ResourceNotFoundException;
import com.alquimiasoft.serviciofactura.repository.IClienteRepository;
import com.alquimiasoft.serviciofactura.util.ValidarIdentificacion;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ClienteService {

    @Autowired
    IClienteRepository clienteRepository;

    // private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(ClienteService.class);
    public Cliente crearCliente(Cliente nuevoCliente) {
        Optional<Cliente> clienteGuardado = Optional.ofNullable(clienteRepository.buscarPorIdentificacion(nuevoCliente.getIdentificacion()));
        // boolean verificaIdentificion = ValidarIdentificacion.isValidCedulaRuc(nuevoCliente.getIdentificacion());
        // LOGGER.info("Verifica identificacion -> "+verificaIdentificion);
        if(clienteGuardado.isPresent()){
            throw new ResourceNotFoundException("El cliente ya existe en la base de datos: " + nuevoCliente.getIdentificacion());
        }
        if(nuevoCliente.getTipoIdentificacion() == "RUC"){
            if(nuevoCliente.getIdentificacion().length() == 10){
                nuevoCliente.setIdentificacion(nuevoCliente.getIdentificacion() + "001");
                return clienteRepository.save(nuevoCliente);
            }else{
                throw new ResourceNotFoundException("El cliente tiene que ingresar los 10 digitos en la identificacio");
            }
        }else if(nuevoCliente.getIdentificacion().length()==10){
            return clienteRepository.save(nuevoCliente);
        }else{
            throw new ResourceNotFoundException("El cliente tiene que ingresar los 10 digitos en la identificacion");
        }
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

    // Servicio para actualizar la informacion del cliente
    public Cliente actualizarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }
}
