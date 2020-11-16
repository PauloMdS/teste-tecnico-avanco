package com.paulomdsbh.avanco.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulomdsbh.avanco.entidades.Pedido;
import com.paulomdsbh.avanco.repositorios.PedidoRepositorio;

@Service
public class PedidoServico {

	@Autowired
	private PedidoRepositorio repositorio;

	public List<Pedido> findAll() {
		return repositorio.findAll();
	}

	public Pedido findById(Long id) {
		Optional<Pedido> obj = repositorio.findById(id);
		return obj.get();
	}

	public void deletar(Long id) {
		repositorio.deleteById(id);
	}

}
