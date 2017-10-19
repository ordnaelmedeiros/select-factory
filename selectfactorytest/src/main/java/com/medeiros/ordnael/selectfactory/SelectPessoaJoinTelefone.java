package com.medeiros.ordnael.selectfactory;

public class SelectPessoaJoinTelefone {

	private String sqlType = "inner";
	private String sqlJoin = " join telefone ";
	private String sqlOn = " on telefone.pessoaId = pessoa.id ";
	
	private SelectPessoaJoin join;
	private SelectPessoaJoinTelefoneTipo tipo;

	public SelectPessoaJoinTelefone(SelectPessoaJoin selectPessoaJoin) {
		this.join = selectPessoaJoin;
	}
	
	public SelectPessoaJoinTelefoneTipo tipo() {
		return new SelectPessoaJoinTelefoneTipo(this);
	}
	
	public SelectPessoaJoin end() {
		join.select().addJoin(sqlType + sqlJoin + sqlOn);
		return join;
	}
	
	public SelectPessoaJoinTelefone on(String value) {
		sqlOn = value;
		return this;
	}
	
	public SelectPessoaJoinTelefone notImplicit() {
		sqlOn = "";
		return this;
	}
	
	public SelectPessoaJoinTelefone left() {
		sqlType = "left";
		return this;
	}

	public void addFilter(String value) {
		if (sqlOn.equals("")) {
			sqlOn = " on " + value;
		} else {
			sqlOn += " and " + value;
		}
	}

}
