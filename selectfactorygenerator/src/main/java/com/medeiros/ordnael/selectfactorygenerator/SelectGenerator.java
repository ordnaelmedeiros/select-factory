package com.medeiros.ordnael.selectfactorygenerator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
			} catch (IOException e) {
			}
			
		}
		
	}
	
}
