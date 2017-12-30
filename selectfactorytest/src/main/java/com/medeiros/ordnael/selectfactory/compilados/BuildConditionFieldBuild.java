package com.medeiros.ordnael.selectfactory.compilados;

public class BuildConditionFieldBuild<T> {
	
	private T parent;
	
	public T end() {
		return parent;
	}
	
	public BuildConditionFieldBuild(T parent) {
		this.parent = parent;
	}
	
	public T equal(java.lang.Long value) {
		return this.parent;
	}
	public T nEqual(java.lang.Long value) {
		return this.parent;
	}
	public T less(java.lang.Long value) {
		return this.parent;
	}
	public T lessEqual(java.lang.Long value) {
		return this.parent;
	}
	public T greater(java.lang.Long value) {
		return this.parent;
	}
	public T greaterEqual(java.lang.Long value) {
		return this.parent;
	}
	public T in(java.lang.Long ...value) {
		return this.parent;
	}
	
}
