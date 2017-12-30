package com.medeiros.ordnael.selectfactorygenerator.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;

import com.medeiros.ordnael.selectfactorygenerator.SFGenerator;

public class ReadResourceString {

	public String read(String fileName) throws Exception {
		
		try {
			
			URL resource = SFGenerator.class.getClassLoader().getResource(fileName+".txt");
			StringBuilder sb = new StringBuilder();
			
			try(BufferedReader br = new BufferedReader(new FileReader(resource.getPath()))) {
				
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
