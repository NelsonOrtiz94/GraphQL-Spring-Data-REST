package com.cuenta.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CuentaBancaria {

    @Id
    private String id;

    private Date fechaCreacion;

    private double balance;

    private String divisa;

    @Enumerated(EnumType.STRING)
    private TipoCuenta tipoCuenta;

    @ManyToOne
    private Cliente cliente;

}