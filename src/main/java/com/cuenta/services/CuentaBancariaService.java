package com.cuenta.services;

import com.cuenta.dtos.CuentaBancariaRequestDto;
import com.cuenta.dtos.CuentaBancariaResponseDto;

public interface CuentaBancariaService {

    CuentaBancariaResponseDto addCuenta(CuentaBancariaRequestDto cuentaBancariaRequestDto);

    CuentaBancariaResponseDto updateCuenta(String id,CuentaBancariaRequestDto cuentaBancariaRequestDto);

}