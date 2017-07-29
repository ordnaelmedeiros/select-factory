package com.medeiros.ordnael.selectfactory.select;

public class WhereField<T> {

	private SelectField<T> field;
	private String comparador;
	private T valor;
	
	public SelectField<T> getField() {
		return field;
	}
	public String getComparador() {
		return comparador;
	}
	public T getValor() {
		return valor;
	}
	
	public WhereField(SelectField<T> field, String comparador, T valor) {
		this.field = field;
		this.comparador = comparador;
		this.valor = valor;
	}
	
}
