package com.paulomdsbh.avanco.entidades;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.paulomdsbh.avanco.entidades.enums.StatusPedido;

@Entity
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
		private Instant momento;
		
		private Integer status;
		@ManyToOne
		@JoinColumn(name = "id_cliente")
		private Cliente cliente;
		
		public Pedido() {
			
		}

		public Pedido(Long id, Instant momento, StatusPedido status, Cliente cliente) {
			super();
			this.id = id;
			this.momento = momento;
			setStatus(status);
			this.cliente = cliente;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Instant getMomento() {
			return momento;
		}

		public void setMomento(Instant momento) {
			this.momento = momento;
		}

		
		public StatusPedido getStatus() {
			return StatusPedido.valueOf(status);
		}

		public void setStatus(StatusPedido status) {
			if(status != null)
			this.status = status.getCodigo();
		}

		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pedido other = (Pedido) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}
		
		
}
