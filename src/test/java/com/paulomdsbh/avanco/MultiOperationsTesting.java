package com.paulomdsbh.avanco;

import java.time.Instant;
import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.paulomdsbh.avanco.entidades.Cliente;
import com.paulomdsbh.avanco.entidades.ItemPedido;
import com.paulomdsbh.avanco.entidades.Pedido;
import com.paulomdsbh.avanco.entidades.Produto;
import com.paulomdsbh.avanco.entidades.enums.StatusPedido;
import com.paulomdsbh.avanco.repositorios.ClienteRepositorio;
import com.paulomdsbh.avanco.repositorios.ItemPedidoRepositorio;
import com.paulomdsbh.avanco.repositorios.PedidoRepositorio;
import com.paulomdsbh.avanco.repositorios.ProdutoRepositorio;

@Configuration
@Profile("test")
@SpringBootTest
class MultiOperationsTesting {

	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	@Autowired
	private PedidoRepositorio pedidoRepositorio;
	
	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	
	@Autowired
	
	private ItemPedidoRepositorio itemPedidoRepositorio;
	
	@Test
	void deveriaCriarPedido() {
		Cliente c1 = new Cliente(null,"Marcos ","marcola@gmail.com");
		Cliente c2 = new Cliente(null,"Maria Joana","mariazinha@gmail.com");

		Produto pr1 = new Produto(null,"Motoserra","Para todas suas necessidades de corte", 330.99);
		Produto pr2 = new Produto(null,"Peruca","Parece verdadeiro", 30.99);
		
		Pedido p1 = new Pedido(null, Instant.parse("2020-11-03T16:10:07Z"), StatusPedido.FATURADO, c1);
		
		clienteRepositorio.saveAll(Arrays.asList(c1,c2));
		produtoRepositorio.saveAll(Arrays.asList(pr1,pr2));
		pedidoRepositorio.saveAll(Arrays.asList(p1));

		ItemPedido ip1 = new ItemPedido(p1, pr1, 30, pr1.getPreco());
		
		itemPedidoRepositorio.save(ip1);
		
		Assertions.assertThat(p1.getId()).isNotNull();
		Assertions.assertThat(p1.getMomento()).isEqualTo(Instant.parse("2020-11-03T16:10:07Z"));
		Assertions.assertThat(p1.getStatus()).isEqualByComparingTo(StatusPedido.FATURADO);
		Assertions.assertThat(p1.getCliente()).isEqualTo(c1);
	}

}
