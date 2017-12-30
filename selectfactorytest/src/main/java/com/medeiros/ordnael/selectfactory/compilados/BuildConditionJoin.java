package com.medeiros.ordnael.selectfactory.compilados;

public class BuildConditionJoin<T> {
	
	private T parent;
	private String alias;
	
	public BuildConditionJoin(T parent) {
		this.parent = parent;
	}
	
	public T end() {
		return parent;
	}
	
	public BuildConditionJoin<T> alias(String alias) {
		this.alias = alias;
		return this;
	}
	
	public String getAlias() {
		return this.alias;
	}
	
	public BuildConditionFields<BuildConditionJoin<T>> on() {
		return new BuildConditionFields<BuildConditionJoin<T>>(this);
	}
	
/*onejoins*/
	public BuildJoin<BuildConditionJoin<T>> oneBuild() {
		return new BuildJoin<BuildConditionJoin<T>>(this);
	}
 

/*manyjoins*/
	
}
