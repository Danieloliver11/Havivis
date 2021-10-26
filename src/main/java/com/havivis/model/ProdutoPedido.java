package com.havivis.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ProdutoPedido implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne
	private Produto produto;
	@Id
	@ManyToOne
	private Pedido pedido;
	
	private int quantidade;
	
	private double valor;
	
	

	public ProdutoPedido(Produto produto, Pedido pedido, int quantidade, double valor) {
		
		this.produto = produto;
		this.pedido = pedido;
		this.quantidade = quantidade;
		this.valor = valor;
	}
	
	
	 
	public double getValor() {
		return valor;
	}



	public void setValor(double valor) {
		this.valor = valor;
	}



	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
