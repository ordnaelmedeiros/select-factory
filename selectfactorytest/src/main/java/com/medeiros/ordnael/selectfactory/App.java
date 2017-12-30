package com.medeiros.ordnael.selectfactory;

import java.time.LocalDateTime;
import java.time.Month;

import com.medeiros.ordnael.selectfactory.compilados.BuildSelect;
import com.medeiros.ordnael.selectfactorygenerator.SFGenerator;

public class App {

	public static void main(String[] args) {
		
		try {
			new SFGenerator(
					"/home/leandro/GitHub/ordnaelmedeiros/select-factory/selectfactorytest/src/main/java/com/medeiros/ordnael/selectfactory/compilados",
					"com.medeiros.ordnael.selectfactory.compilados",
					"")
			.create();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		new BuildSelect()
			.manyUploadBuild()
				.on()
					.user().equal(1l)
				.end()
			.end()
			.where()
				.complete().greater(LocalDateTime.of(2017, Month.JANUARY, 1, 0, 0))
			.end();
		
	}
	
	
}
