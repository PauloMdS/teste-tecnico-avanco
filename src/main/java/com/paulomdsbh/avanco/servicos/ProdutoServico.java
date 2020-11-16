package com.paulomdsbh.avanco.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulomdsbh.avanco.entidades.Produto;
import com.paulomdsbh.avanco.repositorios.ProdutoRepositorio;

@Service
public class ProdutoServico {

	@Autowired
	private ProdutoRepositorio repositorio;

	public List<Produto> findAll() {
		return repositorio.findAll();
	}

	public Produto findById(Long id) {
		Optional<Produto> obj = repositorio.findById(id);
		return obj.get();
	}
	public Produto inserir(Produto obj) {
		return repositorio.save(obj);
	}

	public void deletar(Long id) {
		repositorio.deleteById(id);
	}
	
	public Produto atualizar(Long id, Produto obj) {
		Produto entidade = repositorio.getOne(id);
		atualizarDados(entidade, obj);
		return repositorio.save(entidade);
	}

	private void atualizarDados(Produto entidade, Produto obj) {
		entidade.setNome(obj.getNome());
		entidade.setDescricao(obj.getDescricao());
		entidade.setPreco(obj.getPreco());
	}
}
