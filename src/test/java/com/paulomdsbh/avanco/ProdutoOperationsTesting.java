package com.paulomdsbh.avanco;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.paulomdsbh.avanco.entidades.Produto;
import com.paulomdsbh.avanco.servicos.ProdutoServico;

@SpringBootTest
class ProdutoOperationsTesting {

	@Autowired
	ProdutoServico produtoServico;
	
	@Test
	void deveriaTestarInsercaoProduto() {
		Produto pr1 = new Produto(null,"Motoserra","Para todas suas necessidades de corte", 330.99);
		this.produtoServico.inserir(pr1);
		Assertions.assertThat(pr1.getId()).isNotNull();
		Assertions.assertThat(pr1.getNome()).isEqualTo("Motoserra");
		Assertions.assertThat(pr1.getDescricao()).isEqualTo("Para todas suas necessidades de corte");
		Assertions.assertThat(pr1.getPreco()).isEqualTo(330.99);
	}

}
