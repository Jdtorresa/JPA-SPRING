package com.CellphoneMarket.controlador;

import com.CellphoneMarket.servicios.ProductoService;
import com.CellphoneMarket.persistence.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/all")
    public ResponseEntity<List<Producto>> obtenerProductos() {
        return new ResponseEntity<>(productoService.listaProductos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Integer id) {
        Optional<Producto> producto = productoService.productoPorId(id);
        if (producto.isPresent()) {
            return new ResponseEntity<>(producto.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/insertar")
    public ResponseEntity<Producto> insertarProducto(@RequestBody Producto producto) {
        if (productoService.productoPorId(producto.getIdProducto()).isPresent()) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        } else {
            Producto nuevoProducto = productoService.insertarProducto(producto);
            return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable int id) {
        if (productoService.productoPorId(id).isPresent()) {
            productoService.eliminarProducto(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Producto> actualizarProducto(@RequestBody Producto producto) {
        if (productoService.productoPorId(producto.getIdProducto()).isPresent()) {
            Producto productoActualizado = productoService.actualizarProducto(producto);
            return new ResponseEntity<>(productoActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/proveedor/{nit}")
    public ResponseEntity<List<Producto>> obtenerProductosPorProveedor(@PathVariable String nit) {
        return new ResponseEntity<>(productoService.productosSegunNitAsc(nit), HttpStatus.OK);
    }
}