package com.paulomdsbh.avanco.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.paulomdsbh.avanco.entidades.Cliente;
import com.paulomdsbh.avanco.repositorios.ClienteRepositorio;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private ClienteRepositorio clienteRepositorio;

	@Override
	public void run(String... args) throws Exception {
		Cliente c1 = new Cliente(null,"Marcos ","marcola@gmail.com");
		Cliente c2 = new Cliente(null,"Maria Joana","mariazinha@gmail.com");
		
		clienteRepositorio.saveAll(Arrays.asList(c1,c2));
	}
}
