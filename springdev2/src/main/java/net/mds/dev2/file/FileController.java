package net.mds.dev2.file;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.renderable.ParameterBlock;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.imageio.ImageIO;
import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import net.coobird.thumbnailator.Thumbnails;

@Controller
@RequestMapping("file")
public class FileController {
	private static final Logger logger = LoggerFactory.getLogger(FileController.class);

	@Value("${upload.url}")
	private String uploadUrl;

	@RequestMapping(value = "upload", method = RequestMethod.GET)
	public void upload() {

	}

	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public ModelAndView upload(FileVO fileVO) throws IllegalStateException, IOException {
		CommonsMultipartFile cmf = fileVO.getUpFile();

		if (cmf == null) {
			logger.info("file 전송 안되었다");
			return null;
		}

		long fileSize = cmf.getSize();
		String originalName = cmf.getOriginalFilename();
		File file = new File(uploadUrl, originalName);
		try {
			cmf.transferTo(file);
		} catch (FileNotFoundException e) {
			createUploadDir();
			cmf.transferTo(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		//////////////////////////////////////////////
		/////////// ImageThumbnail ///////////////////
		//////////////////////////////////////////////
/*		boolean isImage = cmf.getContentType().substring(0, 6).toLowerCase().equals("image/");

		if (isImage) {
			String ext = cmf.getContentType().substring(6).toLowerCase();

			ParameterBlock pb = new ParameterBlock();
			pb.add(uploadUrl + "/" + originalName);
			RenderedOp rOp = JAI.create("fileload", pb);
			BufferedImage bi = rOp.getAsBufferedImage();
			BufferedImage thumb = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = thumb.createGraphics();
			g.drawImage(bi, 0, 0, 100, 100, null);
			File f = new File(uploadUrl + "/thumb_" + originalName);
			ImageIO.write(thumb, ext, f);
		}*/
	      String extention = originalName.substring(originalName.lastIndexOf(".") +   1);
	      
	      boolean isImage = cmf.getContentType().substring(0, 6).toLowerCase().equals("image/") ? true : false;
	      File thumbnail = new File(uploadUrl+"/thumb_"+originalName);
	      if (isImage) {
	          Thumbnails.of(file).size(100, 100).outputFormat(extention).toFile(thumbnail);
	      }
		//////////////////////////////////////////////
		/////////// ImageThumbnail ///////////////////
		//////////////////////////////////////////////

		ModelAndView mav = new ModelAndView();
		mav.setViewName("file/uploadAction");
		mav.addObject("fileSize", fileSize);
		mav.addObject("originalName", originalName);
		return mav;

	}

	private void createUploadDir() {
		File dir = new File(uploadUrl);
		if (!dir.exists()) {
			dir.mkdirs();
			logger.info(uploadUrl + "derectory make");
		}
	}
	
	@RequestMapping(value="download")
	private void downLoad(String filename, HttpServletResponse response) throws Exception {
		logger.info(filename);
		File file = new File(uploadUrl, filename);
		response.setContentLength((int)file.length());
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename='" + URLEncoder.encode(filename,"UTF-8") + "'");
		InputStream is = new BufferedInputStream(new FileInputStream(uploadUrl + "/" + filename));
		OutputStream os = new BufferedOutputStream(response.getOutputStream());
		FileCopyUtils.copy(is,  os);
//		byte[] data = new byte[1024 * 100];
//		while(is.read(data) != -1) {
//			os.write(data);
//		}
		os.flush();
		
		
			//net.coobird dependency
	      /*String extention = originalName.substring(originalName.lastIndexOf(".") +   1);
	      
	      boolean isImage = cmf.getContentType().substring(0, 6).toLowerCase().equals("image/") ? true : false;
	      File thumbnail = new File(uploadUrl+"/thumb_"+originalName);
	      if (isImage) {
	          Thumbnails.of(file).size(100, 100).outputFormat(extention).toFile(thumbnail);
	      }*/
		if(os != null) try{os.close();} catch(Exception e){}
		if(is != null) try{is.close();} catch(Exception e){}
	}

}
