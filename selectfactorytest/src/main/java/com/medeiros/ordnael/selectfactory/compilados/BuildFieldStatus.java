package com.medeiros.ordnael.selectfactory.compilados;

public class BuildFieldStatus<T> {
	
	private T parent;
	
	public T end() {
		return parent;
	}
	
	public BuildFieldStatus(T parent) {
		this.parent = parent;
	}
	
	public T equal(com.medeiros.ordnael.selectfactory.entitys.build.BuildStatus value) {
		return this.parent;
	}
	public T nEqual(com.medeiros.ordnael.selectfactory.entitys.build.BuildStatus value) {
		return this.parent;
	}
	public T less(com.medeiros.ordnael.selectfactory.entitys.build.BuildStatus value) {
		return this.parent;
	}
	public T lessEqual(com.medeiros.ordnael.selectfactory.entitys.build.BuildStatus value) {
		return this.parent;
	}
	public T greater(com.medeiros.ordnael.selectfactory.entitys.build.BuildStatus value) {
		return this.parent;
	}
	public T greaterEqual(com.medeiros.ordnael.selectfactory.entitys.build.BuildStatus value) {
		return this.parent;
	}
	public T in(com.medeiros.ordnael.selectfactory.entitys.build.BuildStatus ...value) {
		return this.parent;
	}
	
}
