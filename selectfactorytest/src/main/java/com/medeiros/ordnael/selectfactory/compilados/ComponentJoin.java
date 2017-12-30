package com.medeiros.ordnael.selectfactory.compilados;

public class ComponentJoin<T> {
	
	private T parent;
	private String alias;
	
	public ComponentJoin(T parent) {
		this.parent = parent;
	}
	
	public T end() {
		return parent;
	}
	
	public ComponentJoin<T> alias(String alias) {
		this.alias = alias;
		return this;
	}
	
	public String getAlias() {
		return this.alias;
	}
	
	public ComponentFields<ComponentJoin<T>> on() {
		return new ComponentFields<ComponentJoin<T>>(this);
	}
	
/*onejoins*/ 

/*manyjoins*/
	public VersionJoin<ComponentJoin<T>> manyVersionComponent() {
		return new VersionJoin<ComponentJoin<T>>(this);
	}

	
}
