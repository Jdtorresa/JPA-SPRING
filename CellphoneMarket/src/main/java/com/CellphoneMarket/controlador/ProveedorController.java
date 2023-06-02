package com.CellphoneMarket.controlador;

import com.CellphoneMarket.persistence.entity.Proveedor;
import com.CellphoneMarket.servicios.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {
    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("/all")
    public ResponseEntity<List<Proveedor>> obtenerProveedores(){
        return new ResponseEntity<>(proveedorService.listaProveedores(), HttpStatus.OK);
    }
    @GetMapping("/{nit}")
    public ResponseEntity<Proveedor> obtenerProveedorPorId(@PathVariable String nit){
        Optional<Proveedor> proveedor= proveedorService.proveedorPorId(nit);
        if(proveedor.isPresent()){
            return new ResponseEntity<>(proveedor.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/insertar")
    public ResponseEntity<Proveedor> insertarProveedor(@RequestBody Proveedor nuevoProveedor){
        if(proveedorService.proveedorPorId(nuevoProveedor.getNit()).isPresent()){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }else{
            return new ResponseEntity<>(proveedorService.insertarProveedor(nuevoProveedor), HttpStatus.CREATED);
        }
    }
    @PutMapping("/actualizar")
    public ResponseEntity<Proveedor> actualizarProveedor(@RequestBody Proveedor actualizadoProveedor){
        if(proveedorService.proveedorPorId(actualizadoProveedor.getNit()).isPresent()){
            return new ResponseEntity<>(proveedorService.actualizarProveedor(actualizadoProveedor), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{nit}")
    public ResponseEntity<Void> eliminarProveedor(@PathVariable String nit){
        if(proveedorService.proveedorPorId(nit).isPresent()){
            proveedorService.eliminarProveedor(nit);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
