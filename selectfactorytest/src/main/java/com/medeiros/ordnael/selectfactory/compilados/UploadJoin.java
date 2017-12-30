package com.medeiros.ordnael.selectfactory.compilados;

public class UploadJoin<T> {
	
	private T parent;
	private String alias;
	
	public UploadJoin(T parent) {
		this.parent = parent;
	}
	
	public T end() {
		return parent;
	}
	
	public UploadJoin<T> alias(String alias) {
		this.alias = alias;
		return this;
	}
	
	public String getAlias() {
		return this.alias;
	}
	
	public UploadFields<UploadJoin<T>> on() {
		return new UploadFields<UploadJoin<T>>(this);
	}
	
/*onejoins*/
	public UserJoin<UploadJoin<T>> oneUser() {
		return new UserJoin<UploadJoin<T>>(this);
	}

	public BuildJoin<UploadJoin<T>> oneBuild() {
		return new BuildJoin<UploadJoin<T>>(this);
	}
 

/*manyjoins*/
	
}
