package com.alquimiasoft.serviciofactura.service;

import com.alquimiasoft.serviciofactura.entity.Direccion;
import com.alquimiasoft.serviciofactura.repository.IDireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DireccionService {
    @Autowired
    IDireccionRepository direccionRepository;

    public Direccion guardarDireccion(Direccion direccion){
        return direccionRepository.save(direccion);
    }
}
