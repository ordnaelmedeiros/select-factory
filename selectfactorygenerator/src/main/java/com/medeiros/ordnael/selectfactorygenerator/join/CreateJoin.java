package com.medeiros.ordnael.selectfactorygenerator.join;

import com.medeiros.ordnael.selectfactorygenerator.SFGenerator;
import com.medeiros.ordnael.selectfactorygenerator.files.ReadResourceString;
import com.medeiros.ordnael.selectfactorygenerator.files.WriteFile;

public class CreateJoin {

	private SFGenerator generator;

	public CreateJoin(SFGenerator generator) {
		this.generator = generator;
	}
	
	public void create() throws Exception {
		
		String classJoin = new ReadResourceString().read("Join");
		
		for (Class<?> classe : this.generator.getClasses()) {
			
			new WriteFile(this.generator.getFolderCreate()+"/"+classe.getSimpleName()+"Join.java")
				.content(classJoin)
				.replaceTag("package", this.generator.getPackageCreate())
				.replaceTag("name", classe.getSimpleName())
				.write();
			
		}
		
	}
	
}
