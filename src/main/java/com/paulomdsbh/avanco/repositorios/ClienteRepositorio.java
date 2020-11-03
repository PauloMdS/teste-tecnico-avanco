package com.paulomdsbh.avanco.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paulomdsbh.avanco.entidades.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

}
