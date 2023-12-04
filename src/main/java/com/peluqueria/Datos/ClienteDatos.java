package com.peluqueria.Datos;

import com.peluqueria.entidades.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDatos extends CrudRepository<Cliente, Long> {
}
