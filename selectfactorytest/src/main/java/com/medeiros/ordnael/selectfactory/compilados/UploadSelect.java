package com.medeiros.ordnael.selectfactory.compilados;

public class UploadSelect {
	
	private String alias;
	
	public UploadSelect() {
	}
	
	public UploadSelect alias(String alias) {
		this.alias = alias;
		return this;
	}
	
	public String getAlias() {
		return this.alias;
	}
	
	public UploadFields<UploadSelect> where() {
		return new UploadFields<UploadSelect>(this);
	}
	
/*onejoins*/
	public UserJoin<UploadSelect> oneUser() {
		return new UserJoin<UploadSelect>(this);
	}

	public BuildJoin<UploadSelect> oneBuild() {
		return new BuildJoin<UploadSelect>(this);
	}
 

/*manyjoins*/
	
}
