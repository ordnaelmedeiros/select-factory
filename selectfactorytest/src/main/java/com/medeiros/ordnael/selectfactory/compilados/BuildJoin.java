package com.medeiros.ordnael.selectfactory.compilados;

public class BuildJoin<T> {
	
	private T parent;
	private String alias;
	
	public BuildJoin(T parent) {
		this.parent = parent;
	}
	
	public T end() {
		return parent;
	}
	
	public BuildJoin<T> alias(String alias) {
		this.alias = alias;
		return this;
	}
	
	public String getAlias() {
		return this.alias;
	}
	
	public BuildFields<BuildJoin<T>> on() {
		return new BuildFields<BuildJoin<T>>(this);
	}
	
/*onejoins*/
	public VersionJoin<BuildJoin<T>> oneVersion() {
		return new VersionJoin<BuildJoin<T>>(this);
	}
 

/*manyjoins*/
	public BuildHashJoin<BuildJoin<T>> manyBuildHashBuild() {
		return new BuildHashJoin<BuildJoin<T>>(this);
	}

	public BuildConditionJoin<BuildJoin<T>> manyBuildConditionBuild() {
		return new BuildConditionJoin<BuildJoin<T>>(this);
	}

	public UploadJoin<BuildJoin<T>> manyUploadBuild() {
		return new UploadJoin<BuildJoin<T>>(this);
	}

	
}
