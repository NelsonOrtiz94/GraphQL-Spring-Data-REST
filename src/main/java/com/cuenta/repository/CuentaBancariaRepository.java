package com.cuenta.repository;

import com.cuenta.entities.CuentaBancaria;
import com.cuenta.entities.TipoCuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface CuentaBancariaRepository extends JpaRepository<CuentaBancaria,String> {

    @RestResource(path = "/byType")
    List<CuentaBancaria> findByTipoCuenta(@Param("t")TipoCuenta tipoCuenta);

}