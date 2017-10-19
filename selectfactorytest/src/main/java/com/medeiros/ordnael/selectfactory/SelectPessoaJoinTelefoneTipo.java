package com.medeiros.ordnael.selectfactory;

public class SelectPessoaJoinTelefoneTipo {

	private SelectPessoaJoinTelefone join;
	
	public SelectPessoaJoinTelefoneTipo(SelectPessoaJoinTelefone join) {
		this.join = join;
	}

	public SelectPessoaJoinTelefone equal(String value) {
		join.addFilter(" telefone.tipo = '"+value+"'");
		return join;
	}

	public SelectPessoaJoinTelefone contains(String value) {
		join.addFilter(" telefone.tipo ilike '%"+value+"%'");
		return join;
	}
	
}
