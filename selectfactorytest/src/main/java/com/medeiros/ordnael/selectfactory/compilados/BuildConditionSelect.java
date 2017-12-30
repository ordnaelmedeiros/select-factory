package com.medeiros.ordnael.selectfactory.compilados;

public class BuildConditionSelect {
	
	private String alias;
	
	public BuildConditionSelect() {
	}
	
	public BuildConditionSelect alias(String alias) {
		this.alias = alias;
		return this;
	}
	
	public String getAlias() {
		return this.alias;
	}
	
	public BuildConditionFields<BuildConditionSelect> where() {
		return new BuildConditionFields<BuildConditionSelect>(this);
	}
	
/*onejoins*/
	public BuildJoin<BuildConditionSelect> oneBuild() {
		return new BuildJoin<BuildConditionSelect>(this);
	}
 

/*manyjoins*/
	
}
