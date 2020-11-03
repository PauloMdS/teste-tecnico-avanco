package com.paulomdsbh.avanco.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.paulomdsbh.avanco.entidades.Cliente;
import com.paulomdsbh.avanco.entidades.Pedido;
import com.paulomdsbh.avanco.repositorios.ClienteRepositorio;
import com.paulomdsbh.avanco.repositorios.PedidoRepositorio;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	@Autowired
	private PedidoRepositorio pedidoRepositorio;
	
	@Override
	public void run(String... args) throws Exception {
		Cliente c1 = new Cliente(null,"Marcos ","marcola@gmail.com");
		Cliente c2 = new Cliente(null,"Maria Joana","mariazinha@gmail.com");
		
		Pedido p1 = new Pedido(null, Instant.parse("2020-11-03T16:10:07Z"), c1);
		Pedido p2 = new Pedido(null, Instant.parse("2020-11-03T16:15:17Z"), c2);
		
		clienteRepositorio.saveAll(Arrays.asList(c1,c2));
		pedidoRepositorio.saveAll(Arrays.asList(p1,p2));
	}
}
