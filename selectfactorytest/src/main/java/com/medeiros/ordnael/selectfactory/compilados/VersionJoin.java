package com.medeiros.ordnael.selectfactory.compilados;

public class VersionJoin<T> {
	
	private T parent;
	private String alias;
	
	public VersionJoin(T parent) {
		this.parent = parent;
	}
	
	public T end() {
		return parent;
	}
	
	public VersionJoin<T> alias(String alias) {
		this.alias = alias;
		return this;
	}
	
	public String getAlias() {
		return this.alias;
	}
	
	public VersionFields<VersionJoin<T>> on() {
		return new VersionFields<VersionJoin<T>>(this);
	}
	
/*onejoins*/
	public ComponentJoin<VersionJoin<T>> oneComponent() {
		return new ComponentJoin<VersionJoin<T>>(this);
	}
 

/*manyjoins*/
	public BuildJoin<VersionJoin<T>> manyBuildVersion() {
		return new BuildJoin<VersionJoin<T>>(this);
	}

	
}
