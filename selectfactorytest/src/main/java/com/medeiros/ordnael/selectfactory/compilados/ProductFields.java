package com.medeiros.ordnael.selectfactory.compilados;

public class ProductFields<T> {
	
	private T parent;
	
	public T end() {
		return parent;
	}
	
	public ProductFields(T parent) {
		this.parent = parent;
	}
	
/*field*/
	public ProductFieldDescription<ProductFields<T>> description () {
		return new ProductFieldDescription<ProductFields<T>>(this);
	}

	public ProductFieldName<ProductFields<T>> name () {
		return new ProductFieldName<ProductFields<T>>(this);
	}

	public ProductFieldId<ProductFields<T>> id () {
		return new ProductFieldId<ProductFields<T>>(this);
	}

}
