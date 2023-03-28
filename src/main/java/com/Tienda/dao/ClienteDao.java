
package com.Tienda.dao;


import com.Tienda.domain.Cliente;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente,Long >{
    
    public List<Cliente> findByNombre(String nombre);
    
    public List<Cliente> findByTelefono(String  teelefono);
    
    public List<Cliente> findByApellidosIgnoreCase(String apellidos);
    
}
