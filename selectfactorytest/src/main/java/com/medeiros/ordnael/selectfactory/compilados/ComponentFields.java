package com.medeiros.ordnael.selectfactory.compilados;

public class ComponentFields<T> {
	
	private T parent;
	
	public T end() {
		return parent;
	}
	
	public ComponentFields(T parent) {
		this.parent = parent;
	}
	
/*field*/
	public ComponentFieldDeath<ComponentFields<T>> death () {
		return new ComponentFieldDeath<ComponentFields<T>>(this);
	}

	public ComponentFieldCreation<ComponentFields<T>> creation () {
		return new ComponentFieldCreation<ComponentFields<T>>(this);
	}

	public ComponentFieldDescription<ComponentFields<T>> description () {
		return new ComponentFieldDescription<ComponentFields<T>>(this);
	}

	public ComponentFieldFileName<ComponentFields<T>> fileName () {
		return new ComponentFieldFileName<ComponentFields<T>>(this);
	}

	public ComponentFieldName<ComponentFields<T>> name () {
		return new ComponentFieldName<ComponentFields<T>>(this);
	}

	public ComponentFieldId<ComponentFields<T>> id () {
		return new ComponentFieldId<ComponentFields<T>>(this);
	}

}
