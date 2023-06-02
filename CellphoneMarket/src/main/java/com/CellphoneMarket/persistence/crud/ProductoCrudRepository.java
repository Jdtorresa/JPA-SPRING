package com.CellphoneMarket.persistence.crud;

import com.CellphoneMarket.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    List<Producto> findByNitProveedorOrderByPrecioDesc(String nit);
}
