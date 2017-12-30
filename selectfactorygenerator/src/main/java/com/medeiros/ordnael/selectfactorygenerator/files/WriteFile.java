package com.medeiros.ordnael.selectfactorygenerator.files;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteFile {

	private String path;
	private String content;

	public WriteFile(String path) {
		this.path = path;
	}
	
	public WriteFile content(String content) {
		this.content = content;
		return this;
	}
	
	public WriteFile replaceTag(String tag, String value) {
		this.content = this.content.replace("{"+tag+"}", value);
		return this;
	}
	
	public WriteFile replaceComment(String comment, String value) {
		this.content = this.content.replace("/*"+comment+"*/", value);
		return this;
	}
	
	public void write() throws Exception {
		
		FileWriter fw = new FileWriter(path);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(this.content);
		bw.close();
		fw.close();
		
	}
	
}
