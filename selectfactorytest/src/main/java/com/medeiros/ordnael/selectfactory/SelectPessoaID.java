package com.medeiros.ordnael.selectfactory;

public class SelectPessoaID {

	private SelectPessoaWhere where;
	
	public SelectPessoaID(SelectPessoaWhere where) {
		this.where = where;
	}

	public SelectPessoaWhere equal(long l) {
		where.select().addFilter(" pessoa.id = '"+l+"'");
		return where;
	}

}
