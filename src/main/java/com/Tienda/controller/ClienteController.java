/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.Tienda.controller;

import com.Tienda.domain.Cliente;
import com.Tienda.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author esteb
 */
@Controller
public class ClienteController {
    
   
    @Autowired
    ClienteService clienteService;

    @GetMapping("/cliente/listado")
    public String inicio(Model model) {
        var clientes=clienteService.getClientes();
        
        var limiteTotal=0;   //Para sumar la variable se va sumando
        for (var c: clientes) {
            limiteTotal+=c.getCredito().getLimite();
        }
        model.addAttribute("limiteTotal",limiteTotal);//Limite total
        model.addAttribute("totalClientes",clientes.size());//Total de clientes
        
        model.addAttribute("clientes",clientes);
        return "/cliente/listado";
    }

    @GetMapping("/cliente/nuevo")
    public String nuevoCliente(Cliente cliente) {

        return "/cliente/modificar";          //NUEVO CLIENTE

    }

    @PostMapping("/cliente/guardar")
    public String guardarCliente(Cliente cliente) {
        clienteService.save(cliente);           //GUARDAR CLIENTE
        return "redirect:/cliente/listado";

    }

    @GetMapping("/cliente/modificar/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model) {

        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);        //MODIFICAR CLIENTE
        return "/cliente/modificar";

    }

    @GetMapping("/cliente/eliminar/{idCliente}")
    public String eliminarCliente(Cliente cliente) {
                                                           //ELIMINAR CLIENTE
        clienteService.delete(cliente);
        return "redirect:/cliente/listado";

    }
    
    
    
    @GetMapping("/cliente/buscar")
    public String buscar(Cliente cliente) {
        
        return "/cliente/buscarCliente";
    }

    
    
   
    @PostMapping("/cliente/busqueda")
    public String busqueda(Cliente cliente,Model model) {
       // clienteService.save(cliente); 
        
        var clientes = clienteService.findByNombre(cliente.getNombre());
        
        model.addAttribute("resultados", clientes);

        return "redirect:/cliente/buscarCliente";

    }
}
