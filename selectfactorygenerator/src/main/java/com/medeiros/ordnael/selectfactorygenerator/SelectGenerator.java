package com.medeiros.ordnael.selectfactorygenerator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.JoinColumn;

//


public class SelectGenerator {
	
	private String filePathSearch;
	private String filePathGenerate;
	private String javaPathName;
	
	private List<Class<?>> listClass;
	
	public SelectGenerator(String filePathSearch, String filePathGenerate, String javaPathName) {
		
		this.filePathSearch = filePathSearch;
		this.filePathGenerate = filePathGenerate;
		this.javaPathName = javaPathName;
		
	}
	
	public void execute() {
		
		System.out.println("Start search class in " + filePathSearch);
		
		this.listClass = new ArrayList<>();
		new SearchEntitys().searchPackage(new File(filePathSearch), this.listClass);
		
		System.out.println("Creating package in " + filePathGenerate);
		File pkgSelect = new File(filePathGenerate+"/select");
		pkgSelect.mkdirs();
		
		File pkgImpl = new File(filePathGenerate+"/impl");
		new DeletePackage().deletePackate(pkgImpl);
		pkgImpl.mkdirs();
		
		for (Class<?> class1 : this.listClass) {
			File pkgs = new File(filePathGenerate+"/impl/"+class1.getSimpleName().toLowerCase());
			pkgs.mkdirs();
			File fileSelectImpl = new File(filePathGenerate+"/impl/"+class1.getSimpleName().toLowerCase()+"/Select"+class1.getSimpleName()+"Impl.java");
			try {
				fileSelectImpl.createNewFile();
				FileWriter fileWriter = new FileWriter(fileSelectImpl);
				
				fileWriter.write("package "+javaPathName+".impl."+class1.getSimpleName().toLowerCase()+";\n\n");
				
				fileWriter.write("import javax.persistence.EntityManager;\n");
				fileWriter.write("import com.medeiros.ordnael.selectfactorycore.select.SelectTable;\n");
				fileWriter.write("import com.medeiros.ordnael.selectfactorycore.select.SelectField;\n");
				fileWriter.write("import "+class1.getCanonicalName()+";\n");
				fileWriter.write("import "+javaPathName+".select."+class1.getSimpleName().toLowerCase()+".Select"+class1.getSimpleName()+";\n\n");
				
				
				fileWriter.write("public abstract class Select"+class1.getSimpleName()+"Impl extends SelectTable<"+class1.getSimpleName()+", Select"+class1.getSimpleName()+"> {\n\n");
				
				String strFields = null;
				
				for (Field field : class1.getDeclaredFields()) {
					
					String fieldName = field.getName();
					String fieldType = field.getType().getSimpleName();
					
					JoinColumn joinAnnotation = field.getAnnotation(JoinColumn.class);
					if (joinAnnotation!=null && joinAnnotation.name()!=null) {
						fieldName = joinAnnotation.name();
						fieldType = "Long";
					}
					
					
					fileWriter.write("	public static SelectField<"+fieldType+"> "+fieldName.toUpperCase()+" = new SelectField<>(\""+fieldName+"\");\n");
					if (strFields!=null) {
						strFields += "," + fieldName.toUpperCase();
					} else {
						strFields = fieldName.toUpperCase();
					}
					
				}
				
				fileWriter.write("	public static SelectField<?>[] ALL =  {"+strFields+"};");
				
				/*
				public static SelectField<Long> ID = new SelectField<Long>("id");
				public static SelectField<String> NOME = new SelectField<String>("nome");
				*/
				
				fileWriter.write("\n	public Select"+class1.getSimpleName()+"Impl(EntityManager em) {\n");
				fileWriter.write("		super(em);\n");
				fileWriter.write("	}\n\n");
				
				fileWriter.write("	protected Class<"+class1.getSimpleName()+"> getTableClass() {\n");
				fileWriter.write("		return "+class1.getSimpleName()+".class;\n");
				fileWriter.write("	}\n\n");
				
				fileWriter.write("}");
				
				fileWriter.close();
				
			} catch (IOException e) {
			}
			
		}
		
		for (Class<?> class1 : this.listClass) {
			
			File pkgs = new File(filePathGenerate+"/select/"+class1.getSimpleName().toLowerCase());
			pkgs.mkdirs();
			File fileSelectImpl = new File(filePathGenerate+"/select/"+class1.getSimpleName().toLowerCase()+"/Select"+class1.getSimpleName()+".java");
			
			if (!fileSelectImpl.exists()) {
			
				try {
					fileSelectImpl.createNewFile();
					FileWriter fileWriter = new FileWriter(fileSelectImpl);
					
					fileWriter.write("package "+javaPathName+".select."+class1.getSimpleName().toLowerCase()+";\n\n");
					fileWriter.write("import javax.persistence.EntityManager;\n");
					fileWriter.write("import "+javaPathName+".impl."+class1.getSimpleName().toLowerCase()+".Select"+class1.getSimpleName()+"Impl;\n\n");
					
					fileWriter.write("public class Select"+class1.getSimpleName()+" extends Select"+class1.getSimpleName()+"Impl {\n\n");
					
					fileWriter.write("	public Select"+class1.getSimpleName()+"(EntityManager em) {\n");
					fileWriter.write("		super(em);\n");
					fileWriter.write("	}\n\n");
					
					fileWriter.write("	protected Select"+class1.getSimpleName()+" getThis() {\n");
					fileWriter.write("		return this;\n");
					fileWriter.write("	}\n\n");
					
					fileWriter.write("}");
					
					fileWriter.close();
					
				} catch (IOException e) {
				}
				
			}
			
		}
		
	}
	
}
