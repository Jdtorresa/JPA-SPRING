package com.CellphoneMarket.servicios;

import com.CellphoneMarket.persistence.crud.ProductoCrudRepository;
import com.CellphoneMarket.persistence.crud.ProveedorCrudRepository;
import com.CellphoneMarket.persistence.entity.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService {
    @Autowired
    private ProveedorCrudRepository proveedorCrudRepository;

    public List<Proveedor> listaProveedores(){
        return (List<Proveedor>) proveedorCrudRepository.findAll();
    }
    public Optional<Proveedor> proveedorPorId(String nit){
        return proveedorCrudRepository.findById(nit);
    }
    public Proveedor insertarProveedor(Proveedor proveedor){
        return  proveedorCrudRepository.save(proveedor);
    }
    public void eliminarProveedor(String nit){
        proveedorCrudRepository.deleteById(nit);
    }
    public Proveedor actualizarProveedor(Proveedor nuevoProveedor){
        return proveedorCrudRepository.findById(nuevoProveedor.getNit())
                .map(proveedor -> {
                    proveedor.setRazonSocial(nuevoProveedor.getRazonSocial());
                    proveedor.setDireccion(nuevoProveedor.getDireccion());
                    return proveedorCrudRepository.save(proveedor);
                }).get();
    }

}
