package com.medeiros.ordnael.selectfactorygenerator.field;

import java.lang.reflect.Field;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.medeiros.ordnael.selectfactorygenerator.SFGenerator;
import com.medeiros.ordnael.selectfactorygenerator.files.ReadResourceString;
import com.medeiros.ordnael.selectfactorygenerator.files.WriteFile;
import com.medeiros.ordnael.selectfactorygenerator.util.Utils;

public class CreateField {

	private SFGenerator generator;

	public CreateField(SFGenerator generator) {
		this.generator = generator;
	}
	
	public void create() throws Exception {
		
		String textField = new ReadResourceString().read("Field");
		
		for (Class<?> classe : this.generator.getClasses()) {
			
			for (Field field : classe.getDeclaredFields()) {
				
				String path = this.generator.getFolderCreate()+"/"+classe.getSimpleName()+"Field"+Utils.nomeFieldCreate(field.getName())+".java";
				
				String type = field.getType().getCanonicalName();
				if (field.getType().isAnnotationPresent(Entity.class)) {
					for (Field field2 : field.getType().getDeclaredFields()) {
						if (field2.isAnnotationPresent(Id.class)) {
							type = field2.getType().getCanonicalName();
							break;
						}
					}
				}
				
				new WriteFile(path)
					.content(textField)
					.replaceTag("package", this.generator.getPackageCreate())
					.replaceTag("class_name", classe.getSimpleName())
					.replaceTag("field_name", Utils.nomeFieldCreate(field.getName()))
					.replaceTag("type", type)
					.write();
				
				
			}
			
		}
		
	}
	
}
