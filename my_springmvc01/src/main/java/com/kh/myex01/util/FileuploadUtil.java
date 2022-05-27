package com.kh.myex01.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileuploadUtil {

	public static String uploadFile(String path,
								String originalFilename,
								byte[] originalFile) 
	{
		UUID uuid=UUID.randomUUID();
		String targetFileName=path+"/"+uuid+"_"+originalFilename;
		System.out.println("FileuploadUtil targetFileName :"+targetFileName);
		File targetFile=new File(targetFileName);
		try {
			FileCopyUtils.copy(originalFile, targetFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return targetFileName;
	}
}
