package com.peluqueria.servicio;

import com.peluqueria.Datos.TurnoDatos;
import com.peluqueria.entidades.Turno;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicioTurnoImp implements ServicioTurno {

    @Autowired
    private TurnoDatos turnoDatos;

    @Override
    @Transactional(readOnly = true)
    public List<Turno> listTurno() {
        return (List<Turno>) turnoDatos.findAll();
    }

    @Override
    @Transactional
    public void save(Turno turno) {
        turnoDatos.save(turno);
    }

    @Override
    @Transactional
    public void delete(Turno turno) {
        turnoDatos.delete(turno);
    }

    @Override
    @Transactional(readOnly = true)
    public Turno find(Turno turno) {
        return turnoDatos.findById(turno.getIdTurno()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Turno findById(Long id) {
        return turnoDatos.findById(id).orElse(null);
    }

}
