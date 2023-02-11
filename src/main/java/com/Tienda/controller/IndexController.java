package com.Tienda.controller;

import com.Tienda.dao.ClienteDao;
import com.Tienda.domain.Cliente;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class IndexController {
    
    @Autowired
    ClienteDao clienteDao;

    @GetMapping("/")
    public String inicio(Model model) {
//        log.info("Ahora desde MVC");
        //       model.addAttribute("Mensaje", "Hola desde el controlador");

        //      Cliente cliente = new Cliente("Esteban","Leiva Aguilar","estebanleiva@gmail.com","84112473");
        //     Cliente cliente2 = new Cliente("Sebas","Leiva Aguilar","estebanleiva@gmail.com","84112473");
//        Cliente cliente3 = new Cliente("julio","Leiva Aguilar","estebanleiva@gmail.com","84112473");
        //      model.addAttribute("objetoCliente",cliente);
        //      model.addAttribute("objetoCliente2",cliente2);
        //      model.addAttribute("objetoCliente3",cliente3);
        //    List<Cliente> clientes = Arrays.asList(cliente,cliente2);
        var clientes=clienteDao.findAll();
        model.addAttribute("clientes", clientes);
        return "index";
    }

}
