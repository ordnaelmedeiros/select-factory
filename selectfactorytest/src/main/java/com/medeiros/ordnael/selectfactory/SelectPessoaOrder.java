package com.medeiros.ordnael.selectfactory;

public class SelectPessoaOrder {

	private SelectPessoa select;
	
	public SelectPessoaOrder(SelectPessoa selectPessoa) {
		this.select = selectPessoa;
	}

	public SelectPessoaOrder id(int position) {
		select.addOrder(position, "pessoa.id");
		return this;
	}
	
	public SelectPessoaOrder nome(int position) {
		select.addOrder(position, "pessoa.nome");
		return this;
	}
	
	public SelectPessoa end() {
		return select();
	}

	public SelectPessoa select() {
		return select;
	}

}
