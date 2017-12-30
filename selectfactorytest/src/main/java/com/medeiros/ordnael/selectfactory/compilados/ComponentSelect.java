package com.medeiros.ordnael.selectfactory.compilados;

public class ComponentSelect {
	
	private String alias;
	
	public ComponentSelect() {
	}
	
	public ComponentSelect alias(String alias) {
		this.alias = alias;
		return this;
	}
	
	public String getAlias() {
		return this.alias;
	}
	
	public ComponentFields<ComponentSelect> where() {
		return new ComponentFields<ComponentSelect>(this);
	}
	
/*onejoins*/ 

/*manyjoins*/
	public VersionJoin<ComponentSelect> manyVersionComponent() {
		return new VersionJoin<ComponentSelect>(this);
	}

	
}
