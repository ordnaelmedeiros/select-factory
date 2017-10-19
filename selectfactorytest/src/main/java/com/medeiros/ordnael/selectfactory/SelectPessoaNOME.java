package com.medeiros.ordnael.selectfactory;

public class SelectPessoaNOME {

	private SelectPessoaWhere where;
	
	public SelectPessoaNOME(SelectPessoaWhere where) {
		this.where = where;
	}

	public SelectPessoaWhere equal(String value) {
		where.select().addFilter(" pessoa.nome = '"+value+"'");
		return where;
	}

	public SelectPessoaWhere contains(String value) {
		where.select().addFilter(" pessoa.nome ilike '%"+value+"%'");
		return where;
	}
	
}
