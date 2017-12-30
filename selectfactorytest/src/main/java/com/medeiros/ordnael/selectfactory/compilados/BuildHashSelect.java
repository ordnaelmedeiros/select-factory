package com.medeiros.ordnael.selectfactory.compilados;

public class BuildHashSelect {
	
	private String alias;
	
	public BuildHashSelect() {
	}
	
	public BuildHashSelect alias(String alias) {
		this.alias = alias;
		return this;
	}
	
	public String getAlias() {
		return this.alias;
	}
	
	public BuildHashFields<BuildHashSelect> where() {
		return new BuildHashFields<BuildHashSelect>(this);
	}
	
/*onejoins*/
	public BuildJoin<BuildHashSelect> oneBuild() {
		return new BuildJoin<BuildHashSelect>(this);
	}
 

/*manyjoins*/
	
}
