package com.alquimiasoft.serviciofactura.controller;

import com.alquimiasoft.serviciofactura.dto.FacturaDto;
import com.alquimiasoft.serviciofactura.entity.Cliente;
import com.alquimiasoft.serviciofactura.entity.Direccion;
import com.alquimiasoft.serviciofactura.service.ClienteService;
import com.alquimiasoft.serviciofactura.service.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/factura")
public class FacturaController {

    @Autowired
    ClienteService clienteService;
    @Autowired
    DireccionService direccionService;

//    private static final Logger LOGGER = Logger.getLogger(ClienteService.class.getName());

    // Medoto Post para guardar los datos del cliente
    @PostMapping("/nuevo")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente ingresarDatosCliente(@RequestBody FacturaDto nuevoCliente){
        /*boolean verificaIdentificion = ValidarIdentificacion.isValidCedulaRuc(nuevoCliente.getCliente().getIdentificacion());
        LOGGER.info("Verifica identificacion -> "+verificaIdentificion);*/
        return clienteService.crearCliente(nuevoCliente.getCliente());
    }

    // Metodo para obtener el listado de clientes
    @GetMapping("/clientes")
    public List<Cliente> listarClientes(){
        return clienteService.obtenerClientes();
    }

    // Metodo para actualizar la informacion del cliente
    @PutMapping("/cliente/{id}")
    public Cliente actualizarCliente(@PathVariable Integer id, @RequestBody FacturaDto infoCliente){
        Cliente datosCliente = clienteService.buscarClientePorId(id);
        System.out.println("Cliente ->" + datosCliente.getIdentificacion());
        System.out.println("Cliente 2 ->" + infoCliente.getCliente().getTipoIdentificacion());
        // Actualizar datos
        if(infoCliente.getCliente().getTipoIdentificacion() != null){
            datosCliente.setTipoIdentificacion(infoCliente.getCliente().getTipoIdentificacion());
        }
        if(infoCliente.getCliente().getTipoIdentificacion() != null){
            datosCliente.setTipoIdentificacion(infoCliente.getCliente().getTipoIdentificacion());
        }
        if(infoCliente.getCliente().getIdentificacion() != null){
            datosCliente.setIdentificacion(infoCliente.getCliente().getIdentificacion());
        }
        if(infoCliente.getCliente().getNombre() != null){
            datosCliente.setNombre(infoCliente.getCliente().getNombre());
        }
        if(infoCliente.getCliente().getCorreo() != null){
            datosCliente.setCorreo(infoCliente.getCliente().getCorreo());
        }
        if(infoCliente.getCliente().getNumeroCelular() != null){
            datosCliente.setNumeroCelular(infoCliente.getCliente().getNumeroCelular());
        }

        // datosCliente.setDirecciones(infoCliente.getCliente().getDirecciones());
        return clienteService.actualizarCliente(datosCliente);
    }

    // Eliminar el resgistro de un cliente
    @DeleteMapping("/cliente/{id}")
    public HttpStatus eliminarCliente(@PathVariable Integer id){
        clienteService.eliminarCliente(id);
        if(clienteService.buscarClientePorId(id)==null){
            return HttpStatus.NO_CONTENT;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El cliente no se pudo borrar");
        }
    }

    // Ingresar más direcciones del cliente
    @PutMapping("/cliente/{id}/direccion")
    public Cliente registrarDirecciones(@PathVariable Integer id,@RequestBody Direccion direccion){
        Cliente clienteActual = clienteService.buscarClientePorId(id);
        List<Direccion> direcciones = clienteActual.getDirecciones();
        if(direcciones.isEmpty()){
            direcciones.add(direccion);
            clienteActual.setDirecciones(direcciones);
        }else{
            direcciones.add(direccion);
            clienteActual.setDirecciones(direcciones);
        }
        return  clienteService.crearCliente(clienteActual);
    }

    // Imprimir clientes con sus direcciones
    @GetMapping("/cliente/{id}")
    public List<Map<String, String>> getDirecciones(@PathVariable Integer id){
        return clienteService.obtenerListaDirecciones(id);
    }

    // Buscar cliente por identificacion
    @GetMapping("/cliente")
    public Cliente buscarCliente(@RequestParam String dni){
        return clienteService.buscarClientePorIdentificacion(dni);
    }

}


