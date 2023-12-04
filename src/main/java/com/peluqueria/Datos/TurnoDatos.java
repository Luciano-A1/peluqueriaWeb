package com.peluqueria.Datos;

import com.peluqueria.entidades.Turno;
import org.springframework.data.repository.CrudRepository;

public interface TurnoDatos extends CrudRepository<Turno, Long>{
    
}
