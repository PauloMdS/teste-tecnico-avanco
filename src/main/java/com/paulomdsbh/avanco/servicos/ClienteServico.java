package com.paulomdsbh.avanco.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulomdsbh.avanco.entidades.Cliente;
import com.paulomdsbh.avanco.repositorios.ClienteRepositorio;

@Service
public class ClienteServico {

	@Autowired
	private ClienteRepositorio repositorio;

	public List<Cliente> findAll() {
		return repositorio.findAll();
	}

	public Cliente findById(Long id) {
		Optional<Cliente> obj = repositorio.findById(id);
		return obj.get();
	}

	public Cliente inserir(Cliente obj) {
		return repositorio.save(obj);
	}

	public void deletar(Long id) {
		repositorio.deleteById(id);
	}
	
	public Cliente atualizar(Long id, Cliente obj) {
		Cliente entidade = repositorio.getOne(id);
		atualizarDados(entidade, obj);
		return repositorio.save(entidade);
	}

	private void atualizarDados(Cliente entidade, Cliente obj) {
		entidade.setNome(obj.getNome());
		entidade.setEmail(obj.getEmail());
	}
}
