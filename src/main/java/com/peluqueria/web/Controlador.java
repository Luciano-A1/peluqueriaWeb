package com.peluqueria.web;

import com.peluqueria.entidades.Cliente;
import com.peluqueria.entidades.Turno;
import com.peluqueria.servicio.ServicioCliente;
import com.peluqueria.servicio.ServicioTurno;
import jakarta.validation.Valid;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
class Controlador {

    private final ServicioCliente servicioCliente;
    private final ServicioTurno servicioTurno;

    @Autowired
    public Controlador(ServicioCliente servicioCliente, ServicioTurno servicioTurno) {
        this.servicioCliente = servicioCliente;
        this.servicioTurno = servicioTurno;
    }

    @GetMapping("/")
    public String comienzo(Model modelo) {
        log.info("Estoy ejecutando el controlador MVC");
        List<Turno> listaDeTurnos = servicioTurno.listTurno();
        List<Cliente> listaDeClientes = servicioCliente.listClientes();
        modelo.addAttribute("listaDeTurnos", listaDeTurnos);
        modelo.addAttribute("listaDeClientes", listaDeClientes);
        return "Indice";
    }

    @GetMapping("/registrarTurno/{idCliente}")
    public String registrarTurno(@PathVariable Long idCliente, Model modelo) {
        Cliente cliente = servicioCliente.findById(idCliente);
        Turno turno = new Turno();
        turno.setCliente(cliente);
        modelo.addAttribute("cliente", cliente);
        modelo.addAttribute("turno", turno);
        return "RegistrarT";
    }

    @GetMapping("/registrar")
    public String registrar(Cliente cliente) {
        return "RegistrarC";
    }

    @GetMapping("/Borrar/{idCliente}")
    public String borrar(Cliente cliente, Model modelo) {
        servicioCliente.delete(cliente);
        return "redirect:/";
    }

    @PostMapping("/insertar")
    public String guardarCliente(@Valid @ModelAttribute("cliente") Cliente cliente, Errors errors) {
        if (errors.hasErrors()) {
            return "RegistrarC";
        }
        servicioCliente.save(cliente);
        return "redirect:/";
    }

    @PostMapping("/insertarT")
    public String guardarTurno(@Valid @ModelAttribute("turno") Turno turno, Errors errors) {
        if (errors.hasErrors()) {
            return "RegistrarT";
        }
        servicioTurno.save(turno);
        return "redirect:/";
    }

}