package com.paulomdsbh.avanco.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paulomdsbh.avanco.entidades.Cliente;
import com.paulomdsbh.avanco.servicos.ClienteServico;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteRecurso {
	
	@Autowired
	private ClienteServico servico;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> findall(){
		List<Cliente> lista = servico.findAll();
				
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id){
		
		Cliente obj = servico.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
