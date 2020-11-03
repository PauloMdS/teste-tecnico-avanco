package com.paulomdsbh.avanco.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paulomdsbh.avanco.entidades.Pedido;

public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {

}
