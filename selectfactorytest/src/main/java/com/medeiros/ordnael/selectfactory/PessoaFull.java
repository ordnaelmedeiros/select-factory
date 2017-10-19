package com.medeiros.ordnael.selectfactory;

import java.util.Arrays;

import javax.persistence.Column;

public class PessoaFull {

	@Column(name="pessoa.id")
	private Long id;
	
	@Column(name="pessoa.nome")
	private String nome;
	
	@Column(name="telefone.tipo")
	private String tipo;
	
	@Column(name="telefone.numero")
	private String numero;
	
	@Override
	public String toString() {
		return Arrays.asList(id, nome, tipo, numero).toString();
	}
	
}
