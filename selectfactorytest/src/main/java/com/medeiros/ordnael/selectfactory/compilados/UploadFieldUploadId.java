package com.medeiros.ordnael.selectfactory.compilados;

public class UploadFieldUploadId<T> {
	
	private T parent;
	
	public T end() {
		return parent;
	}
	
	public UploadFieldUploadId(T parent) {
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
