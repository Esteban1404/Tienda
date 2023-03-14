/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda.service;

import com.Tienda.dao.ClienteDao;
import com.Tienda.dao.CreditoDao;
import com.Tienda.domain.Cliente;
import com.Tienda.domain.Credito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ClienteSevicelmpl implements ClienteService {

    @Autowired
    ClienteDao clienteDao;
  
    @Autowired
    CreditoDao creditoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getClientes() {

        return (List<Cliente>) clienteDao.findAll(); // METODO PARA BUSCAR TODA LA LISTA
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null); //BUSCAR UN UNICO CLIENTE
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {  //MODIFICAR O INSERATR UN NUEVO CLIENTE
        Credito credito = cliente.getCredito();
        credito = creditoDao.save(credito);
        
        cliente.setCredito(credito);
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {

        clienteDao.deleteById(cliente.getIdCliente());   //ELIMINAR CLIENTE
    }

}
