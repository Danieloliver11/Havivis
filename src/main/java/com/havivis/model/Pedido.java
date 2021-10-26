package com.havivis.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.crypto.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int valorExtra;
	private String observacao;
	private String formaDePagamento; //--
	private String status;
	
	@ManyToOne
	@JsonIgnoreProperties("Pedido")
	private Cliente cliente;
	
	@ManyToOne
	@JsonIgnoreProperties("Pedido")
	private Funcionario funcionario;
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)//
	private List<ProdutoPedido> produtoPedidos;
	
	private LocalDateTime dataHora = LocalDateTime.now();
	
   	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getValorExtra() {
		return valorExtra;
	}

	public void setValorExtra(int valorExtra) {
		this.valorExtra = valorExtra;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<ProdutoPedido> getProdutoPedidos() {
		return produtoPedidos;
	}

	public void setProdutoPedidos(List<ProdutoPedido> produtoPedidos) {
		this.produtoPedidos = produtoPedidos;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	

	
	
	

}
