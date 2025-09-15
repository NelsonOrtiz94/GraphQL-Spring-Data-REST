package com.cuenta.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(types = CuentaBancaria.class,name = "p1")
public interface CuentaProjection {

    public String getId();

    public TipoCuenta getTipoCuenta();

    public Double getBalance();

}