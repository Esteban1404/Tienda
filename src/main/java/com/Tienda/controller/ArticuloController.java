/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.Tienda.controller;

import com.Tienda.domain.Articulo;
import com.Tienda.service.ArticuloService;
import com.Tienda.service.ArticuloService;
import com.Tienda.service.CategoriaService;
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
public class ArticuloController {

    @Autowired
    ArticuloService articuloService;
    
    @Autowired
    CategoriaService categoriaService;
    
    
   
    @GetMapping("/articulo/listado")
    public String inicio(Model model) {
               
        var articulos = articuloService.getArticulos(false);
        
        var precioTotal=0;
        for(var c: articulos){
        
            precioTotal+=c.getPrecio();
        
        }        
        model.addAttribute("precioTotal", precioTotal);  
        model.addAttribute("totalArticulos",articulos.size());
        
        model.addAttribute("articulos", articulos);  //Traer lista de articulos

        return "/articulo/listado";
    }

    @GetMapping("/articulo/nuevo")
    public String nuevoArticulo(Articulo articulo,Model model) {
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias",categorias);
        return "/articulo/modificar";          //NUEVO CLIENTE

    }

    @PostMapping("/articulo/guardar")
    public String guardarArticulo(Articulo articulo) {
        articuloService.save(articulo);           //GUARDAR CLIENTE
        return "redirect:/articulo/listado";

    }

    @GetMapping("/articulo/modificar/{idArticulo}")
    public String modificarArticulo(Articulo articulo, Model model) {

         var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias",categorias);
                
        articulo = articuloService.getArticulo(articulo);
        model.addAttribute("articulo", articulo);        //MODIFICAR CLIENTE
        return "/articulo/modificar";

    }

    @GetMapping("/articulo/eliminar/{idArticulo}")
    public String eliminarArticulo(Articulo articulo) {
        //ELIMINAR CLIENTE
        articuloService.delete(articulo);
        return "redirect:/articulo/listado";

    }

}
