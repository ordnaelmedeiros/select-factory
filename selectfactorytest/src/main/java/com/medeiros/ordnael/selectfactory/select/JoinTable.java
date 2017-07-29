package com.medeiros.ordnael.selectfactory.select;

public class JoinTable {

	private SelectTable table;
	private String joinString;
	
	public SelectTable getTable() {
		return table;
	}
	public void setTable(SelectTable table) {
		this.table = table;
	}
	public String getJoinString() {
		return joinString;
	}
	public void setJoinString(String joinString) {
		this.joinString = joinString;
	}
	
	public JoinTable(SelectTable table, String joinString) {
		super();
		this.table = table;
		this.joinString = joinString;
	}
	
	
}
