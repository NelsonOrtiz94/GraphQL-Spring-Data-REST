package com.cuenta.services.impl;

import com.cuenta.dtos.CuentaBancariaRequestDto;
import com.cuenta.dtos.CuentaBancariaResponseDto;
import com.cuenta.entities.CuentaBancaria;
import com.cuenta.mappers.CuentaBancariaMapper;
import com.cuenta.repository.CuentaBancariaRepository;
import com.cuenta.services.CuentaBancariaService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class CuentaBancariaServiceImpl implements CuentaBancariaService {

    private final CuentaBancariaRepository cuentaBancariaRepository;

    private final CuentaBancariaMapper cuentaBancariaMapper;

    public CuentaBancariaServiceImpl(CuentaBancariaRepository cuentaBancariaRepository, CuentaBancariaMapper cuentaBancariaMapper) {
        this.cuentaBancariaRepository = cuentaBancariaRepository;
        this.cuentaBancariaMapper = cuentaBancariaMapper;
    }

    @Override
    public CuentaBancariaResponseDto addCuenta(CuentaBancariaRequestDto cuentaBancariaRequestDto) {
        CuentaBancaria cuentaBancaria = CuentaBancaria.builder()
                .id(UUID.randomUUID().toString())
                .fechaCreacion(new Date())
                .balance(cuentaBancariaRequestDto.getBalance())
                .tipoCuenta(cuentaBancariaRequestDto.getTipoCuenta())
                .divisa(cuentaBancariaRequestDto.getDivisa())
                .build();

        CuentaBancaria cuentaBancariaBBDD = cuentaBancariaRepository.save(cuentaBancaria);
        CuentaBancariaResponseDto cuentaBancariaResponseDto = cuentaBancariaMapper.fromCuentaBancaria(cuentaBancariaBBDD);
        return cuentaBancariaResponseDto;
    }

    @Override
    public CuentaBancariaResponseDto updateCuenta(String id, CuentaBancariaRequestDto cuentaBancariaRequestDto) {
        CuentaBancaria cuentaBancaria = CuentaBancaria.builder()
                .id(id)
                .fechaCreacion(new Date())
                .balance(cuentaBancariaRequestDto.getBalance())
                .tipoCuenta(cuentaBancariaRequestDto.getTipoCuenta())
                .divisa(cuentaBancariaRequestDto.getDivisa())
                .build();

        CuentaBancaria cuentaBancariaBBDD = cuentaBancariaRepository.save(cuentaBancaria);
        CuentaBancariaResponseDto cuentaBancariaResponseDto = cuentaBancariaMapper.fromCuentaBancaria(cuentaBancariaBBDD);
        return cuentaBancariaResponseDto;
    }
}