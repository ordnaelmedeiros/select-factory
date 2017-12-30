package com.medeiros.ordnael.selectfactory.compilados;

public class ProductSelect {
	
	private String alias;
	
	public ProductSelect() {
	}
	
	public ProductSelect alias(String alias) {
		this.alias = alias;
		return this;
	}
	
	public String getAlias() {
		return this.alias;
	}
	
	public ProductFields<ProductSelect> where() {
		return new ProductFields<ProductSelect>(this);
	}
	
/*onejoins*/ 

/*manyjoins*/
	
}
