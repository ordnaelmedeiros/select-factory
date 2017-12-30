package com.medeiros.ordnael.selectfactory.compilados;

public class UserFields<T> {
	
	private T parent;
	
	public T end() {
		return parent;
	}
	
	public UserFields(T parent) {
		this.parent = parent;
	}
	
/*field*/
	public UserFieldDeath<UserFields<T>> death () {
		return new UserFieldDeath<UserFields<T>>(this);
	}

	public UserFieldCreation<UserFields<T>> creation () {
		return new UserFieldCreation<UserFields<T>>(this);
	}

	public UserFieldType<UserFields<T>> type () {
		return new UserFieldType<UserFields<T>>(this);
	}

	public UserFieldEmail<UserFields<T>> email () {
		return new UserFieldEmail<UserFields<T>>(this);
	}

	public UserFieldName<UserFields<T>> name () {
		return new UserFieldName<UserFields<T>>(this);
	}

	public UserFieldId<UserFields<T>> id () {
		return new UserFieldId<UserFields<T>>(this);
	}

}
