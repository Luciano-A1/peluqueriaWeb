package com.peluqueria.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
@Table(name = "turno")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdTurno")
    private long idTurno;

    private String horario;

    private boolean efectivo;
    
    @ManyToOne
    @NotNull
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    public Cliente getCliente() {
        return this.cliente;
    }
}

