package com.oneyo.spring.common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUtil {

	public Map<String,String> saveFile(MultipartFile uploadFile, HttpSession session, String type) throws IllegalStateException, IOException {
		Map<String, String> result = new HashMap<String, String>();
		String folderName = type.equals("recipe") ? "nUploadFiles":"rUploadFiles";
		String prefix = type.toLowerCase().substring(0,1);
		String recipeFilename = uploadFile.getOriginalFilename();
		String recipeFileRename = null;
		String recipeFilepath = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String transStr = sdf.format(new Date(System.currentTimeMillis()));
		String ext = recipeFilename.substring(recipeFilename.lastIndexOf(".")+1);
		
		recipeFileRename = transStr + "." + ext;
		recipeFilepath = "/resources/"+folderName+"/"+recipeFileRename;
		String folderPath = session.getServletContext().getRealPath("/resources/"+folderName);
		String savePath = folderPath + "\\" + recipeFileRename;
		uploadFile.transferTo(new File(savePath));
		result.put(prefix+"Filename", recipeFilename);
		result.put(prefix+"FileRename", recipeFileRename);
		result.put(prefix+"Filepath", recipeFilepath);
		return result;
	}
}
