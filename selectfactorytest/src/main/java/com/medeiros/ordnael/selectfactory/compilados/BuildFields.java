package com.medeiros.ordnael.selectfactory.compilados;

public class BuildFields<T> {
	
	private T parent;
	
	public T end() {
		return parent;
	}
	
	public BuildFields(T parent) {
		this.parent = parent;
	}
	
/*field*/
	public BuildFieldStatus<BuildFields<T>> status () {
		return new BuildFieldStatus<BuildFields<T>>(this);
	}

	public BuildFieldNotes<BuildFields<T>> notes () {
		return new BuildFieldNotes<BuildFields<T>>(this);
	}

	public BuildFieldBuild<BuildFields<T>> build () {
		return new BuildFieldBuild<BuildFields<T>>(this);
	}

	public BuildFieldSize<BuildFields<T>> size () {
		return new BuildFieldSize<BuildFields<T>>(this);
	}

	public BuildFieldDeath<BuildFields<T>> death () {
		return new BuildFieldDeath<BuildFields<T>>(this);
	}

	public BuildFieldComplete<BuildFields<T>> complete () {
		return new BuildFieldComplete<BuildFields<T>>(this);
	}

	public BuildFieldCreation<BuildFields<T>> creation () {
		return new BuildFieldCreation<BuildFields<T>>(this);
	}

	public BuildFieldVersion<BuildFields<T>> version () {
		return new BuildFieldVersion<BuildFields<T>>(this);
	}

	public BuildFieldId<BuildFields<T>> id () {
		return new BuildFieldId<BuildFields<T>>(this);
	}

}
