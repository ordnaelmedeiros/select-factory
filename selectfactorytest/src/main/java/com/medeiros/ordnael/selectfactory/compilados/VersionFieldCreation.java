package com.medeiros.ordnael.selectfactory.compilados;

public class VersionFieldCreation<T> {
	
	private T parent;
	
	public T end() {
		return parent;
	}
	
	public VersionFieldCreation(T parent) {
		this.parent = parent;
	}
	
	public T equal(java.time.LocalDateTime value) {
		return this.parent;
	}
	public T nEqual(java.time.LocalDateTime value) {
		return this.parent;
	}
	public T less(java.time.LocalDateTime value) {
		return this.parent;
	}
	public T lessEqual(java.time.LocalDateTime value) {
		return this.parent;
	}
	public T greater(java.time.LocalDateTime value) {
		return this.parent;
	}
	public T greaterEqual(java.time.LocalDateTime value) {
		return this.parent;
	}
	public T in(java.time.LocalDateTime ...value) {
		return this.parent;
	}
	
}
