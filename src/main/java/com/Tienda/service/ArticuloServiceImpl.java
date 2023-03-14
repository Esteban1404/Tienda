package com.Tienda.service;

import com.Tienda.dao.ArticuloDao;

import com.Tienda.domain.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ArticuloServiceImpl implements ArticuloService {

   
    @Autowired
    ArticuloDao articuloDao;

    @Override
    @Transactional(readOnly = true)
    public List<Articulo> getArticulos(boolean activos) {

     
        List<Articulo> lista= (List<Articulo>)articuloDao.findAll(); // METODO PARA BUSCAR TODA LA LISTA
        if(activos){
        
            lista.removeIf(e -> !e.isActivo());
        }
        
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Articulo getArticulo(Articulo articulo) {
        return articuloDao.findById(articulo.getIdArticulo()).orElse(null); //BUSCAR UN UNICO CLIENTE
    }

    @Override
    @Transactional
    public void save(Articulo articulo) {  //MODIFICAR O INSERATR UN NUEVO CLIENTE
        articuloDao.save(articulo);
    }

    @Override
    @Transactional
    public void delete(Articulo articulo) {

        articuloDao.deleteById(articulo.getIdArticulo());   //ELIMINAR CLIENTE
    }

    
    
    
    
}
