package com.medeiros.ordnael.selectfactorygenerator;

import java.io.File;
import java.util.List;

import javax.persistence.Entity;

class SearchEntitys {
	
	public void searchPackage(File file, List<Class<?>> listClass) {
		
		if (file.isDirectory()) {
			File[] listFiles = file.listFiles();
			for (File file2 : listFiles) {
				this.searchPackage(file2, listClass);
			}
		} else if (file.isFile() && file.getName().indexOf(".java")>0) {
			String className = file.getAbsolutePath();
			className = className.replace('\\', '.');
			className = className.replace('/', '.');
			className = className.substring(className.lastIndexOf(".java.")+6, className.length()-5);
			
			try {
				
				Class<?> classe = Class.forName(className);
				Entity ent = classe.getAnnotation(Entity.class);
				if (ent!=null) {
					listClass.add(classe);
					System.out.println("Found: " + className);
				}
				
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}
		
	}

}
