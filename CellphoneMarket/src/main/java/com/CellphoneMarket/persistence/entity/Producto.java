
package com.CellphoneMarket.persistence.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

@Entity
@Table(name="productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    @Column(nullable = false)
    private String referencia;

    @Column(nullable = false)
    private Double precio;
    @ManyToOne
    @JoinColumn(name = "proveedor_nit", referencedColumnName = "nit")
    private Proveedor nitProveedor;
    public Producto() {
    }

    public Producto(Proveedor nitProveedor) {
        this.nitProveedor = nitProveedor;
    }

    public Proveedor getNitProveedor() {
        return nitProveedor;
    }
    public void setNitProveedor(Proveedor nitProveedor) {
        this.nitProveedor = nitProveedor;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

}