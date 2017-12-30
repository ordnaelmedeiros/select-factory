package com.medeiros.ordnael.selectfactorygenerator.files;

import java.io.BufferedReader;
import java.io.FileReader;

import com.medeiros.ordnael.selectfactorygenerator.SFGenerator;

public class ReadJoinString {

	private SFGenerator generator;

	public ReadJoinString(SFGenerator generator) {
		this.generator = generator;
	}
	
	public String read(String fileName) throws Exception {
		
		try {
			
			StringBuilder sb = new StringBuilder();
			
			try(BufferedReader br = new BufferedReader(new FileReader(this.generator.getFolderCreate()+"/"+fileName+"Join.java"))) {
				
				String line = br.readLine();
				
				while (line != null) {
					sb.append(line);
					sb.append(System.lineSeparator());
					line = br.readLine();
				}
				
			}
			
			return sb.toString();
			
		} catch (Exception e) {
			throw e;
		}
		
	}
	
}
