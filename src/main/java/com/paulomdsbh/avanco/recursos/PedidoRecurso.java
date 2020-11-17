package com.paulomdsbh.avanco.recursos;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.paulomdsbh.avanco.entidades.Pedido;
import com.paulomdsbh.avanco.servicos.PedidoServico;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoRecurso {

	@Autowired
	private PedidoServico servico;

	@GetMapping
	public ResponseEntity<List<Pedido>> findall() {
		List<Pedido> lista = servico.findAll();

		return ResponseEntity.ok().body(lista);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable Long id) {

		Pedido obj = servico.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Pedido> inserir(@RequestBody Pedido obj){
		obj = servico.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		servico.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
