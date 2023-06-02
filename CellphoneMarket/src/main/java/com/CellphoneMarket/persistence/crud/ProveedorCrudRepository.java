package com.CellphoneMarket.persistence.crud;

import com.CellphoneMarket.persistence.entity.Proveedor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorCrudRepository extends CrudRepository<Proveedor, String> {

}
