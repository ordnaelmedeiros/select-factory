package com.medeiros.ordnael.selectfactorygenerator.util;

public class Utils {

	public static String nomeFieldCreate(String field) {
		
		String pre = field.substring(0, 1);
		String su = field.substring(1);
		
		return pre.toUpperCase()+su;
		
	}
	
	
}
