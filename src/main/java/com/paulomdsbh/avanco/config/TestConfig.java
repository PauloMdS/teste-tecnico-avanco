package com.paulomdsbh.avanco.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.paulomdsbh.avanco.entidades.Cliente;
import com.paulomdsbh.avanco.entidades.ItemPedido;
import com.paulomdsbh.avanco.entidades.Pagamento;
import com.paulomdsbh.avanco.entidades.Pedido;
import com.paulomdsbh.avanco.entidades.Produto;
import com.paulomdsbh.avanco.entidades.enums.StatusPedido;
import com.paulomdsbh.avanco.repositorios.ClienteRepositorio;
import com.paulomdsbh.avanco.repositorios.ItemPedidoRepositorio;
import com.paulomdsbh.avanco.repositorios.PedidoRepositorio;
import com.paulomdsbh.avanco.repositorios.ProdutoRepositorio;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	@Autowired
	private PedidoRepositorio pedidoRepositorio;
	
	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	
	@Autowired
	
	private ItemPedidoRepositorio itemPedidoRepositorio;
	
	@Override
	public void run(String... args) throws Exception {
		Cliente c1 = new Cliente(null,"Marcos ","marcola@gmail.com");
		Cliente c2 = new Cliente(null,"Maria Joana","mariazinha@gmail.com");

		Produto pr1 = new Produto(null,"Motoserra","Para todas suas necessidades de corte", 330.99);
		Produto pr2 = new Produto(null,"Peruca","Parece verdadeiro", 30.99);
		
		Pedido p1 = new Pedido(null, Instant.parse("2020-11-03T16:10:07Z"), StatusPedido.FATURADO, c1);
		Pedido p2 = new Pedido(null, Instant.parse("2020-11-03T16:15:17Z"), StatusPedido.AGUARDANDO_PAGAMENTO,c2);
		
		clienteRepositorio.saveAll(Arrays.asList(c1,c2));
		produtoRepositorio.saveAll(Arrays.asList(pr1,pr2));
		pedidoRepositorio.saveAll(Arrays.asList(p1,p2));

		ItemPedido ip1 = new ItemPedido(p1, pr2, 3, pr2.getPreco());
		ItemPedido ip2 = new ItemPedido(p1, pr1, 5, pr1.getPreco());
		ItemPedido ip3 = new ItemPedido(p2, pr1, 7, pr1.getPreco());
		
		itemPedidoRepositorio.saveAll(Arrays.asList(ip1, ip2, ip3));
		
		Pagamento pag1 = new Pagamento(null, Instant.parse("2020-11-03T19:05:01Z"), p1);
		
		p1.setPagamento(pag1);
		
		pedidoRepositorio.save(p1);
	}
}
