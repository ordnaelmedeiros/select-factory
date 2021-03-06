package com.medeiros.ordnael.selectfactory.compilados;

public class ComponentFieldDescription<T> {
	
	private T parent;
	
	public T end() {
		return parent;
	}
	
	public ComponentFieldDescription(T parent) {
		this.parent = parent;
	}
	
	public T equal(java.lang.String value) {
		return this.parent;
	}
	public T nEqual(java.lang.String value) {
		return this.parent;
	}
	public T less(java.lang.String value) {
		return this.parent;
	}
	public T lessEqual(java.lang.String value) {
		return this.parent;
	}
	public T greater(java.lang.String value) {
		return this.parent;
	}
	public T greaterEqual(java.lang.String value) {
		return this.parent;
	}
	public T in(java.lang.String ...value) {
		return this.parent;
	}
	
}
