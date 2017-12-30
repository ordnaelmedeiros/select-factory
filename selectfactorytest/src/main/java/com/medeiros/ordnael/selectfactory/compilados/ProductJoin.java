package com.medeiros.ordnael.selectfactory.compilados;

public class ProductJoin<T> {
	
	private T parent;
	private String alias;
	
	public ProductJoin(T parent) {
		this.parent = parent;
	}
	
	public T end() {
		return parent;
	}
	
	public ProductJoin<T> alias(String alias) {
		this.alias = alias;
		return this;
	}
	
	public String getAlias() {
		return this.alias;
	}
	
	public ProductFields<ProductJoin<T>> on() {
		return new ProductFields<ProductJoin<T>>(this);
	}
	
/*onejoins*/ 

/*manyjoins*/
	
}
