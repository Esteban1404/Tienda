/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Tienda.service;

import com.Tienda.domain.Articulo;

import java.util.List;

/**
 *
 * @author esteb
 */
public interface ArticuloService {
    
     public List<Articulo> getArticulos(boolean activos); //TRAER LISTA DE CLIENTES
    
    public Articulo getArticulo(Articulo articulo);//UN UNICO CLIENTE
    
    public void save(Articulo articulo);// Para insertar o modificar (Si viene el idCliente o no)
    
    public void delete (Articulo articulo); //
    
}
