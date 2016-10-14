package net.mds.dev2.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping("file")
public class FileController {
	private static final Logger logger = LoggerFactory.getLogger(FileController.class);
	
	@Value("${upload.url}")
	private String uploadUrl;
	
	@RequestMapping(value = "upload", method=RequestMethod.GET)
	public void upload(){
		
	}
	@RequestMapping(value = "upload", method=RequestMethod.POST)
	public void upload(FileVO fileVO){
		CommonsMultipartFile cmf = fileVO.getUpFile();
		
		if(cmf == null) {
			
		}
	}
}
