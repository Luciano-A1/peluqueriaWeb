package com.peluqueria.servicio;

import com.peluqueria.entidades.Cliente;
import java.util.List;

public interface ServicioCliente {

    public List<Cliente> listClientes();

    public void save(Cliente cliente);

    public void delete(Cliente cliente);

    public Cliente find(Cliente cliente);
    
    public Cliente findById(Long idCliente);
    
}
