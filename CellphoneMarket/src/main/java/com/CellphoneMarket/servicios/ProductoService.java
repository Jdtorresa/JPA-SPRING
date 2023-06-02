package com.CellphoneMarket.servicios;
import com.CellphoneMarket.persistence.crud.ProductoCrudRepository;
import com.CellphoneMarket.persistence.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> listaProductos() {
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public Optional<Producto> productoPorId(Integer id) {
        return productoCrudRepository.findById(id);
    }

    public Producto insertarProducto(Producto producto) {
        return productoCrudRepository.save(producto);
    }

    public void eliminarProducto(int id) {
        productoCrudRepository.deleteById(id);
    }

    public Producto actualizarProducto(Producto nuevoProducto) {
        return productoCrudRepository.findById(nuevoProducto.getIdProducto())
                .map(
                        producto -> {
                            producto.setReferencia(nuevoProducto.getReferencia());
                            producto.setPrecio(nuevoProducto.getPrecio());
                            producto.setNitProveedor(nuevoProducto.getNitProveedor());
                            return productoCrudRepository.save(producto);
                        }
                ).get();
    }

    public List<Producto> productosSegunNitAsc(String nit) {
        return productoCrudRepository.findByNitProveedorOrderByPrecioDesc(nit);
    }
}