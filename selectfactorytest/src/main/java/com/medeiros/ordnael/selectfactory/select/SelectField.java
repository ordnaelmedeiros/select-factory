package com.medeiros.ordnael.selectfactory.select;

public class SelectField<T> {

	private String nome;
	private String alias;
	
	public SelectField(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public String getAlias() {
		return alias;
	}
	
	protected SelectField<T> clone() {
		SelectField<T> sf = new SelectField<T>(this.nome);
		sf.alias = this.alias;
		return sf;
	}
	
	public SelectField<T> setAlias(String alias) {
		SelectField<T> sf = this.clone();
		sf.alias = alias;
		return sf;
	}
	
	public WhereField<T> eq(T value) {
		return new WhereField<T>(this, " = ", value);
	}
	
	public WhereField<T> ne(T value) {
		return new WhereField<T>(this, " <> ", value);
	}
	
}
