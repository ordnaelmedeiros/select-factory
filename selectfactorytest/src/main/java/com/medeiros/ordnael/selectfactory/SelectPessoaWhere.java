package com.medeiros.ordnael.selectfactory;

public class SelectPessoaWhere {

	private SelectPessoa select;
	private SelectPessoaID id;
	private SelectPessoaNOME nome;
	
	public SelectPessoaWhere(SelectPessoa selectPessoa) {
		this.select = selectPessoa;
		this.id = new SelectPessoaID(this);
		this.nome = new SelectPessoaNOME(this);
	}

	public SelectPessoaID id() {
		return id;
	}
	
	public SelectPessoaNOME nome() {
		return nome;
	}
	
	public SelectPessoa end() {
		return select();
	}

	public SelectPessoa select() {
		return select;
	}

}
