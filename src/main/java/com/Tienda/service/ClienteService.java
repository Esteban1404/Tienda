/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Tienda.service;

import com.Tienda.domain.Cliente;
import java.util.List;

public interface ClienteService {

    public List<Cliente> getClientes(); //TRAER LISTA DE CLIENTES

    public Cliente getCliente(Cliente cliente);//UN UNICO CLIENTE

    public void save(Cliente cliente);// Para insertar o modificar (Si viene el idCliente o no)

    public void delete(Cliente cliente); //ELIMINAR CLIENTE

    public List<Cliente> findByNombre(String nombre);
    
     public List<Cliente> findByTelefono(String telefono);
     
     public List<Cliente> findByApellidos( String apellidos);


}
