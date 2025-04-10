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

	public Map<String, String> saveFile(MultipartFile uploadFile, HttpSession session, String type) throws IllegalStateException, IOException{
		Map<String, String> result = new HashMap<String, String>();
		String folderName = type.equals("board") ? "bUploadFiles":"rUploadFiles";
		String prefix = type.toLowerCase().substring(0,1);
		String boardFilename = uploadFile.getOriginalFilename();
		String boardFileRename;
		String boardFilePath;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String transStr = sdf.format(new Date(System.currentTimeMillis()));
		String ext = boardFilename.substring(boardFilename.lastIndexOf(".")+1);
		boardFileRename = transStr + "." + ext;
		boardFilePath = "/resources/"+folderName+"/"+boardFileRename;
		
		String folderPath = session.getServletContext().getRealPath("/resources/"+folderName);
		File dir = new File(folderPath); 
		if (!dir.exists()) { // 디렉토리없을 시 자동생성
			dir.mkdirs();
		}
		
		String savePath = folderPath+"\\"+boardFileRename;
		uploadFile.transferTo(new File(savePath));
		result.put(prefix+"Filename", boardFilename);
		result.put(prefix+"FileRename", boardFileRename);
		result.put(prefix+"FilePath", boardFilePath);
		return result;
	}
	
	public Map<String,String> saveFile1(MultipartFile uploadFile, HttpSession session, String type) throws IllegalStateException, IOException {
		Map<String, String> result = new HashMap<String, String>();
		String folderName = type.equals("step") ? "nUploadFiles":"rUploadFiles";
		String prefix = type.toLowerCase().substring(0,1);
		String stepFilename = uploadFile.getOriginalFilename();
		String stepFileRename = null;
		String stepFilepath = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String transStr = sdf.format(new Date(System.currentTimeMillis()));
		String ext = stepFilename.substring(stepFilename.lastIndexOf(".")+1);
		
		stepFileRename = transStr + "." + ext;
		stepFilepath = "/resources/"+folderName+"/"+stepFileRename;
		String folderPath = session.getServletContext().getRealPath("/resources/"+folderName);
		String savePath = folderPath + "\\" + stepFileRename;
		uploadFile.transferTo(new File(savePath));
		result.put(prefix+"Filename", stepFilename);
		result.put(prefix+"FileRename", stepFileRename);
		result.put(prefix+"Filepath", stepFilepath);
		return result;
	}
	
	public Map<String,String> saveFile2(MultipartFile uploadFile, HttpSession session, String type) throws IllegalStateException, IOException {
		Map<String, String> result = new HashMap<String, String>();
		String folderName = type.equals("sources") ? "nUploadFiles":"rUploadFiles";
		String prefix = type.toLowerCase().substring(0,1);
		String sourcesFilename = uploadFile.getOriginalFilename();
		String sourcesFileRename = null;
		String sourcesFilepath = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String transStr = sdf.format(new Date(System.currentTimeMillis()));
		String ext = sourcesFilename.substring(sourcesFilename.lastIndexOf(".")+1);
		
		sourcesFileRename = transStr + "." + ext;
		sourcesFilepath = "/resources/"+folderName+"/"+sourcesFileRename;
		String folderPath = session.getServletContext().getRealPath("/resources/"+folderName);
		String savePath = folderPath + "\\" + sourcesFileRename;
		uploadFile.transferTo(new File(savePath));
		result.put(prefix+"Filename", sourcesFilename);
		result.put(prefix+"FileRename", sourcesFileRename);
		result.put(prefix+"Filepath", sourcesFilepath);
		return result;
	}
	public Map<String,String> saveRecipeFile(MultipartFile uploadFile, HttpSession session, String type) throws IllegalStateException, IOException {
		Map<String, String> result = new HashMap<String, String>();
		String folderName = type.equals("Recipe") ? "nUploadFiles":"rUploadFiles";
		String prefix = type.toLowerCase().substring(0,1);
		String recipeFilename = uploadFile.getOriginalFilename();
		String recipeFileRename = null;
		String recipeFilepath = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String transStr = sdf.format(new Date(System.currentTimeMillis()));
		String ext = recipeFilename.substring(recipeFilename.lastIndexOf(".")+1);
		
		recipeFileRename = transStr + "." + ext;
		recipeFilepath = "/recipe/"+recipeFilename+"/"+recipeFileRename;
		String folderPath = session.getServletContext().getRealPath("/resources/"+folderName);
		String savePath = folderPath + "\\" + recipeFileRename;
		uploadFile.transferTo(new File(savePath));
		result.put(prefix+"Filename", recipeFilename);
		result.put(prefix+"FileRename", recipeFileRename);
		result.put(prefix+"Filepath", recipeFilepath);
		return result;
	}
}
