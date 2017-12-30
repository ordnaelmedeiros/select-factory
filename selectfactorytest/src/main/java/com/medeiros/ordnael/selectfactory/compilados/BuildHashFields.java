package com.medeiros.ordnael.selectfactory.compilados;

public class BuildHashFields<T> {
	
	private T parent;
	
	public T end() {
		return parent;
	}
	
	public BuildHashFields(T parent) {
		this.parent = parent;
	}
	
/*field*/
	public BuildHashFieldStatus<BuildHashFields<T>> status () {
		return new BuildHashFieldStatus<BuildHashFields<T>>(this);
	}

	public BuildHashFieldCreation<BuildHashFields<T>> creation () {
		return new BuildHashFieldCreation<BuildHashFields<T>>(this);
	}

	public BuildHashFieldHash<BuildHashFields<T>> hash () {
		return new BuildHashFieldHash<BuildHashFields<T>>(this);
	}

	public BuildHashFieldBuild<BuildHashFields<T>> build () {
		return new BuildHashFieldBuild<BuildHashFields<T>>(this);
	}

	public BuildHashFieldBuildId<BuildHashFields<T>> buildId () {
		return new BuildHashFieldBuildId<BuildHashFields<T>>(this);
	}

	public BuildHashFieldId<BuildHashFields<T>> id () {
		return new BuildHashFieldId<BuildHashFields<T>>(this);
	}

}
