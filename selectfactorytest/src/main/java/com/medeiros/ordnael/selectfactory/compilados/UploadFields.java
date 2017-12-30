package com.medeiros.ordnael.selectfactory.compilados;

public class UploadFields<T> {
	
	private T parent;
	
	public T end() {
		return parent;
	}
	
	public UploadFields(T parent) {
		this.parent = parent;
	}
	
/*field*/
	public UploadFieldBytes<UploadFields<T>> bytes () {
		return new UploadFieldBytes<UploadFields<T>>(this);
	}

	public UploadFieldUser<UploadFields<T>> user () {
		return new UploadFieldUser<UploadFields<T>>(this);
	}

	public UploadFieldBuild<UploadFields<T>> build () {
		return new UploadFieldBuild<UploadFields<T>>(this);
	}

	public UploadFieldUploadId<UploadFields<T>> uploadId () {
		return new UploadFieldUploadId<UploadFields<T>>(this);
	}

}
