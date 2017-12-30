package com.medeiros.ordnael.selectfactory.compilados;

public class VersionFieldRelease<T> {
	
	private T parent;
	
	public T end() {
		return parent;
	}
	
	public VersionFieldRelease(T parent) {
		this.parent = parent;
	}
	
	public T equal(java.lang.Integer value) {
		return this.parent;
	}
	public T nEqual(java.lang.Integer value) {
		return this.parent;
	}
	public T less(java.lang.Integer value) {
		return this.parent;
	}
	public T lessEqual(java.lang.Integer value) {
		return this.parent;
	}
	public T greater(java.lang.Integer value) {
		return this.parent;
	}
	public T greaterEqual(java.lang.Integer value) {
		return this.parent;
	}
	public T in(java.lang.Integer ...value) {
		return this.parent;
	}
	
}
