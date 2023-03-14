
package com.Tienda.service;

import com.Tienda.dao.CategoriaDao;

import com.Tienda.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CategoriaServiceImpl implements CategoriaService {

   
    @Autowired
    CategoriaDao categoriaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> getCategorias(boolean activos) {

     
        List<Categoria> lista= (List<Categoria>)categoriaDao.findAll(); // METODO PARA BUSCAR TODA LA LISTA
        if(activos){
        
            lista.removeIf(e -> !e.isActivo());
        }
        
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null); //BUSCAR UN UNICO CLIENTE
    }

    @Override
    @Transactional
    public void save(Categoria categoria) {  //MODIFICAR O INSERATR UN NUEVO CLIENTE
        categoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Categoria categoria) {

        categoriaDao.deleteById(categoria.getIdCategoria());   //ELIMINAR CLIENTE
    }

    
    
    
    
}
