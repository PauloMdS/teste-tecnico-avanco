package com.paulomdsbh.avanco;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.paulomdsbh.avanco.entidades.Cliente;
import com.paulomdsbh.avanco.servicos.ClienteServico;

@Configuration
@Profile("test")
@SpringBootTest
class ClienteOperationsTesting {

	@Autowired
	ClienteServico clienteServico;

	@Test
	void deveriaTestarInsercaoCliente() {

		Cliente c1 = new Cliente(null, "João da Silva", "silvense@gmail.com");
		this.clienteServico.inserir(c1);
		Assertions.assertThat(c1.getId()).isNotNull();
		Assertions.assertThat(c1.getNome()).isEqualTo("João da Silva");
		Assertions.assertThat(c1.getEmail()).isEqualTo("silvense@gmail.com");
	}

}
