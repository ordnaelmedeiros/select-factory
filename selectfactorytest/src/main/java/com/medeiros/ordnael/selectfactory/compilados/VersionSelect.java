package com.medeiros.ordnael.selectfactory.compilados;

public class VersionSelect {
	
	private String alias;
	
	public VersionSelect() {
	}
	
	public VersionSelect alias(String alias) {
		this.alias = alias;
		return this;
	}
	
	public String getAlias() {
		return this.alias;
	}
	
	public VersionFields<VersionSelect> where() {
		return new VersionFields<VersionSelect>(this);
	}
	
/*onejoins*/
	public ComponentJoin<VersionSelect> oneComponent() {
		return new ComponentJoin<VersionSelect>(this);
	}
 

/*manyjoins*/
	public BuildJoin<VersionSelect> manyBuildVersion() {
		return new BuildJoin<VersionSelect>(this);
	}

	
}
