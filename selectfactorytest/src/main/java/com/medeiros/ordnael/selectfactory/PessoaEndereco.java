package com.medeiros.ordnael.selectfactory;

public class PessoaEndereco {

	private Long pessoaId;
	private String nome;
	private Long enderecoId;
	private String bairro;
	private String rua;
	private Integer numero;
	
	public Long getId() {
		return pessoaId;
	}
	public void setId(Long id) {
		this.pessoaId = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Long getEnderecoId() {
		return enderecoId;
	}
	public void setEnderecoId(Long enderecoId) {
		this.enderecoId = enderecoId;
	}
	
}
