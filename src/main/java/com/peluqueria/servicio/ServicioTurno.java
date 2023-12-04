package com.peluqueria.servicio;

import com.peluqueria.entidades.Turno;
import java.util.List;

public interface ServicioTurno {

    public List<Turno> listTurno();

    public void save(Turno turno);

    public void delete(Turno turno);

    public Turno find(Turno turno);
    
     public Turno findById(Long idTurno);
}
