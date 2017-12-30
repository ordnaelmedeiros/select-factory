package com.medeiros.ordnael.selectfactory.compilados;

public class BuildSelect {
	
	private String alias;
	
	public BuildSelect() {
	}
	
	public BuildSelect alias(String alias) {
		this.alias = alias;
		return this;
	}
	
	public String getAlias() {
		return this.alias;
	}
	
	public BuildFields<BuildSelect> where() {
		return new BuildFields<BuildSelect>(this);
	}
	
/*onejoins*/
	public VersionJoin<BuildSelect> oneVersion() {
		return new VersionJoin<BuildSelect>(this);
	}
 

/*manyjoins*/
	public BuildHashJoin<BuildSelect> manyBuildHashBuild() {
		return new BuildHashJoin<BuildSelect>(this);
	}

	public BuildConditionJoin<BuildSelect> manyBuildConditionBuild() {
		return new BuildConditionJoin<BuildSelect>(this);
	}

	public UploadJoin<BuildSelect> manyUploadBuild() {
		return new UploadJoin<BuildSelect>(this);
	}

	
}
