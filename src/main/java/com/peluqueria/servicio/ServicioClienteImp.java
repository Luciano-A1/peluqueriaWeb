package com.peluqueria.servicio;

import com.peluqueria.Datos.ClienteDatos;
import com.peluqueria.entidades.Cliente;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ServicioClienteImp implements ServicioCliente{
    
    @Autowired
    private ClienteDatos clienteDatos;
    
    @Override
    @Transactional(readOnly = true)
    public List<Cliente> listClientes() {
         return (List<Cliente>) clienteDatos.findAll();
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        clienteDatos.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDatos.delete(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente find(Cliente cliente) {
        return clienteDatos.findById(cliente.getIdCliente()).orElse(null);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Cliente findById(Long idCliente){
         return clienteDatos.findById(idCliente).orElse(null);
    }
    
}
