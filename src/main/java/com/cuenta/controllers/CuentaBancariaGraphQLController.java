package com.cuenta.controllers;

import com.cuenta.dtos.CuentaBancariaRequestDto;
import com.cuenta.dtos.CuentaBancariaResponseDto;
import com.cuenta.entities.Cliente;
import com.cuenta.entities.CuentaBancaria;
import com.cuenta.repository.ClienteRepository;
import com.cuenta.repository.CuentaBancariaRepository;
import com.cuenta.services.CuentaBancariaService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CuentaBancariaGraphQLController {

    private final CuentaBancariaRepository cuentaBancariaRepository;
    private final ClienteRepository clienteRepository;
    private final CuentaBancariaService cuentaBancariaService;

    public CuentaBancariaGraphQLController(CuentaBancariaRepository cuentaBancariaRepository, ClienteRepository clienteRepository, CuentaBancariaService cuentaBancariaService) {
        this.cuentaBancariaRepository = cuentaBancariaRepository;
        this.clienteRepository = clienteRepository;
        this.cuentaBancariaService = cuentaBancariaService;
    }

    @QueryMapping
    public List<CuentaBancaria> listarCuentas(){
        return cuentaBancariaRepository.findAll();
    }

    @QueryMapping
    public CuentaBancaria cuentaBancariaPorId(@Argument String id){
        System.out.println("ID recibido: [" + id + "]");
        List<CuentaBancaria> cuentas = cuentaBancariaRepository.findAll();
        for(CuentaBancaria cuenta:cuentas){
            if(cuenta.getId().trim().equals(id.trim())){
                System.out.println("Coinciendia exacta encontrada");
                return cuenta;
            }
        }
        throw new RuntimeException("Cuenta [" + id + "] no encontrada");
    }

    @MutationMapping
    public CuentaBancariaResponseDto agregarCuenta(@Argument CuentaBancariaRequestDto cuentaBancaria){
        return cuentaBancariaService.addCuenta(cuentaBancaria);
    }

    @MutationMapping
    public CuentaBancariaResponseDto actualizarCuenta(@Argument String id, @Argument CuentaBancariaRequestDto cuentaBancaria){
        return cuentaBancariaService.updateCuenta(id,cuentaBancaria);
    }

    @MutationMapping
    public void eliminarCuenta(@Argument String id){
        cuentaBancariaRepository.deleteById(id);
    }

    @QueryMapping
    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }
}