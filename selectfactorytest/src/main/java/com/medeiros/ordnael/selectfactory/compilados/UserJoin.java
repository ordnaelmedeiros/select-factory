package com.medeiros.ordnael.selectfactory.compilados;

public class UserJoin<T> {
	
	private T parent;
	private String alias;
	
	public UserJoin(T parent) {
		this.parent = parent;
	}
	
	public T end() {
		return parent;
	}
	
	public UserJoin<T> alias(String alias) {
		this.alias = alias;
		return this;
	}
	
	public String getAlias() {
		return this.alias;
	}
	
	public UserFields<UserJoin<T>> on() {
		return new UserFields<UserJoin<T>>(this);
	}
	
/*onejoins*/ 

/*manyjoins*/
	public UploadJoin<UserJoin<T>> manyUploadUser() {
		return new UploadJoin<UserJoin<T>>(this);
	}

	
}
