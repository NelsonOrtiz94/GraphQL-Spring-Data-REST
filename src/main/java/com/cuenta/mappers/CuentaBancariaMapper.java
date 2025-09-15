package com.cuenta.mappers;

import com.cuenta.dtos.CuentaBancariaResponseDto;
import com.cuenta.entities.CuentaBancaria;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CuentaBancariaMapper {

    public CuentaBancariaResponseDto fromCuentaBancaria(CuentaBancaria cuentaBancaria){
        CuentaBancariaResponseDto cuentaBancariaResponseDto = new CuentaBancariaResponseDto();
        BeanUtils.copyProperties(cuentaBancaria,cuentaBancariaResponseDto);
        return cuentaBancariaResponseDto;
    }

}