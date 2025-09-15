package com.cuenta.controllers;

import com.cuenta.dtos.CuentaBancariaRequestDto;
import com.cuenta.dtos.CuentaBancariaResponseDto;
import com.cuenta.entities.CuentaBancaria;
import com.cuenta.repository.CuentaBancariaRepository;
import com.cuenta.services.CuentaBancariaService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/")
public class CuentaBancariaController {

    private final CuentaBancariaRepository cuentaBancariaRepository;
    private final CuentaBancariaService cuentaBancariaService;

    public CuentaBancariaController(CuentaBancariaRepository cuentaBancariaRepository, CuentaBancariaService cuentaBancariaService) {
        this.cuentaBancariaRepository = cuentaBancariaRepository;
        this.cuentaBancariaService = cuentaBancariaService;
    }

    @GetMapping("/cuentas")
    public List<CuentaBancaria> listarCuentasBancarias(){
        return cuentaBancariaRepository.findAll();
    }

    @GetMapping("/cuentas/{id}")
    public CuentaBancaria obtenerCuentaBancaria(@PathVariable String id){
        return cuentaBancariaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Cuenta %s no encontrada",id)));
    }

    @PostMapping("/cuentas")
    public CuentaBancariaResponseDto guardarCuenta(@RequestBody CuentaBancariaRequestDto cuentaBancariaRequestDto){
        return cuentaBancariaService.addCuenta(cuentaBancariaRequestDto);
    }

    @PutMapping("/cuentas/{id}")
    public CuentaBancaria actualizarCuenta(@PathVariable String id,@RequestBody CuentaBancaria cuentaBancaria){
        CuentaBancaria cuentaBancariaBBDD = cuentaBancariaRepository.findById(id).orElseThrow();
        cuentaBancariaBBDD.setBalance(cuentaBancaria.getBalance());
        cuentaBancariaBBDD.setFechaCreacion(new Date());
        cuentaBancariaBBDD.setTipoCuenta(cuentaBancaria.getTipoCuenta());
        cuentaBancariaBBDD.setDivisa(cuentaBancaria.getDivisa());
        return cuentaBancariaRepository.save(cuentaBancariaBBDD);
    }

    @DeleteMapping("/cuentas/{id}")
    public void eliminarCuenta(@PathVariable String id){
        cuentaBancariaRepository.deleteById(id);
    }
}