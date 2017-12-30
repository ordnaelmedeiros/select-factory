package com.medeiros.ordnael.selectfactory.compilados;

public class BuildConditionFields<T> {
	
	private T parent;
	
	public T end() {
		return parent;
	}
	
	public BuildConditionFields(T parent) {
		this.parent = parent;
	}
	
/*field*/
	public BuildConditionFieldStatus<BuildConditionFields<T>> status () {
		return new BuildConditionFieldStatus<BuildConditionFields<T>>(this);
	}

	public BuildConditionFieldDescription<BuildConditionFields<T>> description () {
		return new BuildConditionFieldDescription<BuildConditionFields<T>>(this);
	}

	public BuildConditionFieldBuild<BuildConditionFields<T>> build () {
		return new BuildConditionFieldBuild<BuildConditionFields<T>>(this);
	}

	public BuildConditionFieldId<BuildConditionFields<T>> id () {
		return new BuildConditionFieldId<BuildConditionFields<T>>(this);
	}

}
