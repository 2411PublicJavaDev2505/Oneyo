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

	public Map<String, String> saveFile( MultipartFile uploadFile, HttpSession session, String type) throws IllegalStateException, IOException{
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
}
