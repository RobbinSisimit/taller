/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.robbinsisimit.webapp.service;

import jakarta.persistence.EntityManager;
import java.util.List;
import org.robbinsisimit.webapp.model.Producto;
import org.robbinsisimit.webapp.util.JPAUtil;

/**
 *
 * @author informatica
 */
public class ProductoService implements IProductoService{
    private EntityManager em;
    
    public ProductoService(){
        this.em = JPAUtil.getEntityManager();
    }
    
    @Override
    public List<Producto> listarProducto() {
        return em.createQuery("SELECT p FROM Producto p", Producto.class).getResultList();
    }

    @Override
    public void agregarProducto(Producto producto) {
        em.persist(producto);
    }

    @Override
    public void eliminarProducto(int productoId) {
        
    }

    @Override
    public Producto buscarProductoId(int productoId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editarProducto(Producto producto) {
        
    }
    
}
