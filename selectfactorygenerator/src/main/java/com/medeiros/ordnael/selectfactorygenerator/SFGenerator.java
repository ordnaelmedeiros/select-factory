package com.medeiros.ordnael.selectfactorygenerator;

import java.util.ArrayList;
import java.util.List;

import com.medeiros.ordnael.selectfactorygenerator.clean.Clean;
import com.medeiros.ordnael.selectfactorygenerator.field.CreateField;
import com.medeiros.ordnael.selectfactorygenerator.field.CreateTableFields;
import com.medeiros.ordnael.selectfactorygenerator.join.CreateJoin;
import com.medeiros.ordnael.selectfactorygenerator.join.CreateOneJoin;
import com.medeiros.ordnael.selectfactorygenerator.scan.ScanClass;
import com.medeiros.ordnael.selectfactorygenerator.select.CreateSelect;

public class SFGenerator {

	private List<Class<?>> classes = new ArrayList<>();
	
	private String folderCreate;
	private String packageCreate;
	private String packageScan;

	public SFGenerator(String folderCreate, String packageCreate, String packageScan) {
		this.folderCreate = folderCreate;
		this.packageCreate = packageCreate;
		this.packageScan = packageScan;
	}
	
	public String getPackageCreate() {
		return packageCreate;
	}
	public String getFolderCreate() {
		return folderCreate;
	}
	public String getPackageScan() {
		return packageScan;
	}
	
	public void addClass(Class<?> classe) {
		this.classes.add(classe);
	}
	public List<Class<?>> getClasses() {
		return classes;
	}
	
	public void create() throws Exception {
		
		new Clean(this).clean();
		new ScanClass(this).scan();
		
		new CreateTableFields(this).create();
		new CreateField(this).create();
		
		new CreateJoin(this).create();
		new CreateSelect(this).create();
		new CreateOneJoin(this).create();
		
	}
	
	/*
	public String getFoinFile() {
		
		URL resource = Main.class.getClassLoader().getResource("Join.txt");
		return resource.getPath();
		
	}
	*/
	
}
