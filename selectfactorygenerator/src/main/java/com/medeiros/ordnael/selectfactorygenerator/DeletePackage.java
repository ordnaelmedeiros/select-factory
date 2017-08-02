package com.medeiros.ordnael.selectfactorygenerator;

import java.io.File;

class DeletePackage {

	public void deletePackate(File file) {

		if (file.isDirectory()) {
			File[] listFiles = file.listFiles();
			for (File file2 : listFiles) {
				this.deletePackate(file2);
			}
		}
		file.delete();

	}

}
