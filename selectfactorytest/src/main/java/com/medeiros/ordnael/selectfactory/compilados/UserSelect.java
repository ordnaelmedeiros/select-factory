package com.medeiros.ordnael.selectfactory.compilados;

public class UserSelect {
	
	private String alias;
	
	public UserSelect() {
	}
	
	public UserSelect alias(String alias) {
		this.alias = alias;
		return this;
	}
	
	public String getAlias() {
		return this.alias;
	}
	
	public UserFields<UserSelect> where() {
		return new UserFields<UserSelect>(this);
	}
	
/*onejoins*/ 

/*manyjoins*/
	public UploadJoin<UserSelect> manyUploadUser() {
		return new UploadJoin<UserSelect>(this);
	}

	
}
