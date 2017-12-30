package com.medeiros.ordnael.selectfactory.compilados;

public class UserFieldType<T> {
	
	private T parent;
	
	public T end() {
		return parent;
	}
	
	public UserFieldType(T parent) {
		this.parent = parent;
	}
	
	public T equal(org.hibernate.usertype.UserType value) {
		return this.parent;
	}
	public T nEqual(org.hibernate.usertype.UserType value) {
		return this.parent;
	}
	public T less(org.hibernate.usertype.UserType value) {
		return this.parent;
	}
	public T lessEqual(org.hibernate.usertype.UserType value) {
		return this.parent;
	}
	public T greater(org.hibernate.usertype.UserType value) {
		return this.parent;
	}
	public T greaterEqual(org.hibernate.usertype.UserType value) {
		return this.parent;
	}
	public T in(org.hibernate.usertype.UserType ...value) {
		return this.parent;
	}
	
}
