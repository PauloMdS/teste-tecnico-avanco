package com.paulomdsbh.avanco.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paulomdsbh.avanco.entidades.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {

}
