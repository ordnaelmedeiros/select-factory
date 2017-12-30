package com.medeiros.ordnael.selectfactorygenerator.field;

import java.lang.reflect.Field;

import com.medeiros.ordnael.selectfactorygenerator.SFGenerator;
import com.medeiros.ordnael.selectfactorygenerator.files.ReadResourceString;
import com.medeiros.ordnael.selectfactorygenerator.files.WriteFile;
import com.medeiros.ordnael.selectfactorygenerator.util.Utils;

public class CreateTableFields {

	private SFGenerator generator;

	public CreateTableFields(SFGenerator generator) {
		this.generator = generator;
	}
	
	public void create() throws Exception {
		
		String textField = new ReadResourceString().read("TableFields");
		String fieldField = new ReadResourceString().read("TableFieldsField");
		
		for (Class<?> classe : this.generator.getClasses()) {
			
			String path = this.generator.getFolderCreate()+"/"+classe.getSimpleName()+"Fields.java";
			
			WriteFile writeFile = new WriteFile(path)
				.content(textField)
				.replaceTag("package", this.generator.getPackageCreate());
			
			for (Field field : classe.getDeclaredFields()) {
				
				String pathFields = classe.getSimpleName()+"Field"+Utils.nomeFieldCreate(field.getName());
				writeFile
					.replaceComment("field", fieldField)
					.replaceTag("field_class", pathFields)
					.replaceTag("nome_field", field.getName());
				
				
			}
			
			writeFile.replaceTag("class_name", classe.getSimpleName()).write();
			
		}
		
	}
	
}
