package com.medeiros.ordnael.selectfactorygenerator.scan;

import java.io.File;
import java.net.URL;

import javax.persistence.Entity;

import com.medeiros.ordnael.selectfactorygenerator.SFGenerator;

public class ScanClass {

	private SFGenerator generator;

	public ScanClass(SFGenerator generator) {
		this.generator = generator;
	}
	
	public String pathPrincipal = "";
	
	public void scan() {
		
		URL url = SFGenerator.class.getClassLoader().getResource("");
		File directory = new File(url.getPath());
		pathPrincipal = directory.getPath();
		
		buscaFiles(directory);
		System.out.println("sucesso: "+directory.getPath());
		
		System.out.println("ALL CLASSES ENTITY");
		for (Class<?> classe : this.generator.getClasses()) {
			System.out.println(classe);
		}
		System.out.println("");
		
	}
	
	private void buscaFiles(File file) {
		
		if (file.exists()) {
			if (file.isFile()) {
				if (file.getPath().endsWith(".class")) {
					addNaLista(file.getPath());
				}
			} else if (file.isDirectory()) {
				for (File file2 : file.listFiles()) {
					buscaFiles(file2);
				}
			}
		}
		
	}
	
	public void addNaLista(String texto) {
		texto = texto
				.replaceAll(pathPrincipal, "")
				.replaceAll("/", ".")
				.replaceAll(".class", "");
		if (texto.startsWith(".")) {
			texto = texto.substring(1);
		}
		try {
			Class<?> classe = Class.forName(texto);
			if (classe.isAnnotationPresent(Entity.class)) {
				generator.addClass(classe);
			}
		} catch (Exception e) {
		}
	}
	
}
