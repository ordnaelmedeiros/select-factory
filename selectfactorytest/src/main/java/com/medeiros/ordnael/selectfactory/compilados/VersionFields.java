package com.medeiros.ordnael.selectfactory.compilados;

public class VersionFields<T> {
	
	private T parent;
	
	public T end() {
		return parent;
	}
	
	public VersionFields(T parent) {
		this.parent = parent;
	}
	
/*field*/
	public VersionFieldDescription<VersionFields<T>> description () {
		return new VersionFieldDescription<VersionFields<T>>(this);
	}

	public VersionFieldRelease<VersionFields<T>> release () {
		return new VersionFieldRelease<VersionFields<T>>(this);
	}

	public VersionFieldMinor<VersionFields<T>> minor () {
		return new VersionFieldMinor<VersionFields<T>>(this);
	}

	public VersionFieldMajor<VersionFields<T>> major () {
		return new VersionFieldMajor<VersionFields<T>>(this);
	}

	public VersionFieldDeath<VersionFields<T>> death () {
		return new VersionFieldDeath<VersionFields<T>>(this);
	}

	public VersionFieldCreation<VersionFields<T>> creation () {
		return new VersionFieldCreation<VersionFields<T>>(this);
	}

	public VersionFieldComponent<VersionFields<T>> component () {
		return new VersionFieldComponent<VersionFields<T>>(this);
	}

	public VersionFieldId<VersionFields<T>> id () {
		return new VersionFieldId<VersionFields<T>>(this);
	}

}
