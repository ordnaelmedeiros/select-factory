package com.medeiros.ordnael.selectfactory.compilados;

public class UploadFieldBytes<T> {
	
	private T parent;
	
	public T end() {
		return parent;
	}
	
	public UploadFieldBytes(T parent) {
		this.parent = parent;
	}
	
	public T equal(byte[] value) {
		return this.parent;
	}
	public T nEqual(byte[] value) {
		return this.parent;
	}
	public T less(byte[] value) {
		return this.parent;
	}
	public T lessEqual(byte[] value) {
		return this.parent;
	}
	public T greater(byte[] value) {
		return this.parent;
	}
	public T greaterEqual(byte[] value) {
		return this.parent;
	}
	public T in(byte[] ...value) {
		return this.parent;
	}
	
}
