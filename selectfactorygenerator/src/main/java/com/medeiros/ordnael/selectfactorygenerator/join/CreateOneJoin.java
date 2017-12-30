package com.medeiros.ordnael.selectfactorygenerator.join;

import java.lang.reflect.Field;

import javax.persistence.ManyToOne;

import com.medeiros.ordnael.selectfactorygenerator.SFGenerator;
import com.medeiros.ordnael.selectfactorygenerator.files.ReadJoinString;
import com.medeiros.ordnael.selectfactorygenerator.files.ReadResourceString;
import com.medeiros.ordnael.selectfactorygenerator.files.ReadSelectString;
import com.medeiros.ordnael.selectfactorygenerator.files.WriteFile;
import com.medeiros.ordnael.selectfactorygenerator.util.Utils;

public class CreateOneJoin {

	private SFGenerator generator;

	public CreateOneJoin(SFGenerator generator) {
		this.generator = generator;
	}
	
	public void create() throws Exception {
		
		String classOneJoin = new ReadResourceString().read("JoinMethodOne");
		String classSelectOneJoin = new ReadResourceString().read("SelectMethodOne");
		String classManyJoin = new ReadResourceString().read("JoinMethodMany");
		String classSelectManyJoin = new ReadResourceString().read("SelectMethodMany");
		
		for (Class<?> classe : this.generator.getClasses()) {
			
			for (Field field : classe.getDeclaredFields()) {
				if (field.isAnnotationPresent(ManyToOne.class)) {
					
					String pathFileJoin = this.generator.getFolderCreate()+"/"+classe.getSimpleName()+"Join.java";
					
					new WriteFile(pathFileJoin)
						.content(new ReadJoinString(this.generator).read(classe.getSimpleName()))
						.replaceComment("onejoins", classOneJoin)
						.replaceTag("name", classe.getSimpleName())
						.replaceTag("name_join", field.getType().getSimpleName())
						.replaceTag("name_field", Utils.nomeFieldCreate(field.getName()))
						.write();
					
					
					pathFileJoin = this.generator.getFolderCreate()+"/"+field.getType().getSimpleName()+"Join.java";
					
					new WriteFile(pathFileJoin)
						.content(new ReadJoinString(this.generator).read(field.getType().getSimpleName()))
						.replaceComment("manyjoins", classManyJoin)
						.replaceTag("name", classe.getSimpleName())
						.replaceTag("name_join", field.getType().getSimpleName())
						.replaceTag("name_field", Utils.nomeFieldCreate(field.getName()))
						.write();
					
					pathFileJoin = this.generator.getFolderCreate()+"/"+classe.getSimpleName()+"Select.java";
					
					new WriteFile(pathFileJoin)
						.content(new ReadSelectString(this.generator).read(classe.getSimpleName()))
						.replaceComment("onejoins", classSelectOneJoin)
						.replaceTag("name", classe.getSimpleName())
						.replaceTag("name_join", field.getType().getSimpleName())
						.replaceTag("name_field", Utils.nomeFieldCreate(field.getName()))
						.write();
					
					
					pathFileJoin = this.generator.getFolderCreate()+"/"+field.getType().getSimpleName()+"Select.java";
					
					new WriteFile(pathFileJoin)
						.content(new ReadSelectString(this.generator).read(field.getType().getSimpleName()))
						.replaceComment("manyjoins", classSelectManyJoin)
						.replaceTag("name", classe.getSimpleName())
						.replaceTag("name_join", field.getType().getSimpleName())
						.replaceTag("name_field", Utils.nomeFieldCreate(field.getName()))
						.write();
					
				}
				
			}
			
		}
		
	}
	
}
