package com.medeiros.ordnael.selectfactory;

public class SelectPessoaJoin {

	private SelectPessoa select;
	
	private SelectPessoaJoinTelefone telefone;
	
	public SelectPessoaJoin(SelectPessoa selectPessoa) {
		this.select = selectPessoa;
		this.telefone = new SelectPessoaJoinTelefone(this);
	}
	
	public SelectPessoaJoinTelefone telefone() {
		return telefone;
	}

	public SelectPessoa end() {
		return select();
	}

	public SelectPessoa select() {
		return select;
	}

}
