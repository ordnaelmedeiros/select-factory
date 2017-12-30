package com.medeiros.ordnael.selectfactorygenerator.select;

import com.medeiros.ordnael.selectfactorygenerator.SFGenerator;
import com.medeiros.ordnael.selectfactorygenerator.files.ReadResourceString;
import com.medeiros.ordnael.selectfactorygenerator.files.WriteFile;

public class CreateSelect {

	private SFGenerator generator;

	public CreateSelect(SFGenerator generator) {
		this.generator = generator;
	}
	
	public void create() throws Exception {
		
		String classJoin = new ReadResourceString().read("Select");
		
		for (Class<?> classe : this.generator.getClasses()) {
			
			new WriteFile(this.generator.getFolderCreate()+"/"+classe.getSimpleName()+"Select.java")
				.content(classJoin)
				.replaceTag("package", this.generator.getPackageCreate())
				.replaceTag("name", classe.getSimpleName())
				.write();
			
		}
		
	}
	
}
