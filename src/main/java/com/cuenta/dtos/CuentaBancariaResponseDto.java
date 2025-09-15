package com.cuenta.dtos;

import com.cuenta.entities.TipoCuenta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CuentaBancariaResponseDto {

    private String id;
    private Date fechaCreacion;
    private double balance;
    private String divisa;
    private TipoCuenta tipoCuenta;

}