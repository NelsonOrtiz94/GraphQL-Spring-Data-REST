package com.cuenta.dtos;

import com.cuenta.entities.TipoCuenta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CuentaBancariaRequestDto {

    private double balance;
    private String divisa;
    private TipoCuenta tipoCuenta;

}