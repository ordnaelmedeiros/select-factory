package com.medeiros.ordnael.selectfactorygenerator.clean;

import java.io.File;

import com.medeiros.ordnael.selectfactorygenerator.SFGenerator;

public class Clean {

	private SFGenerator generator;

	public Clean(SFGenerator g) {
		this.generator = g;
	}
	
	public void clean() {
		File file = new File(this.generator.getFolderCreate());
		if (file.exists()) {
			for(File f : file.listFiles()){
			    f.delete();
			}
		}
	}
	
}
