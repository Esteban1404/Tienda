
package com.Tienda.service;

import com.Tienda.domain.Categoria;
import java.util.List;


public interface CategoriaService {
    
    public List<Categoria> getCategorias(boolean activos); //TRAER LISTA DE CLIENTES
    
    public Categoria getCategoria(Categoria categoria);//UN UNICO CLIENTE
    
    public void save(Categoria categoria);// Para insertar o modificar (Si viene el idCliente o no)
    
    public void delete (Categoria categoria); //ELIMINAR CLIENTE
    
    
    
}
