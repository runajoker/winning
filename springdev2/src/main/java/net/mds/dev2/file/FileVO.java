package net.mds.dev2.file;

import java.io.Serializable;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FileVO implements Serializable{

	
	private CommonsMultipartFile upFile;

	
	public CommonsMultipartFile getUpFile() {
		return upFile;
	}

	public void setUpFile(CommonsMultipartFile upFile) {
		this.upFile = upFile;
	}
	
	
}
