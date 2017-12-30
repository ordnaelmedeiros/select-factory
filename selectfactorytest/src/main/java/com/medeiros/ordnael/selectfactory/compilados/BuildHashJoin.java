package com.medeiros.ordnael.selectfactory.compilados;

public class BuildHashJoin<T> {
	
	private T parent;
	private String alias;
	
	public BuildHashJoin(T parent) {
		this.parent = parent;
	}
	
	public T end() {
		return parent;
	}
	
	public BuildHashJoin<T> alias(String alias) {
		this.alias = alias;
		return this;
	}
	
	public String getAlias() {
		return this.alias;
	}
	
	public BuildHashFields<BuildHashJoin<T>> on() {
		return new BuildHashFields<BuildHashJoin<T>>(this);
	}
	
/*onejoins*/
	public BuildJoin<BuildHashJoin<T>> oneBuild() {
		return new BuildJoin<BuildHashJoin<T>>(this);
	}
 

/*manyjoins*/
	
}
