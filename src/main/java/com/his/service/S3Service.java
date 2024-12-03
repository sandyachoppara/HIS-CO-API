package com.his.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.util.IOUtils;

@Service
public class S3Service {

	@Value("${bucketName}")
	private String bucketName;

	private final AmazonS3 s3;

	public S3Service(AmazonS3 s3) {
		this.s3 = s3;
	}

	public String saveFile(File file) {
//		String originalFilename = file.getName();
//				PutObjectResult putObjectResult = s3.putObject(bucketName, originalFilename, file);
//				String contentMd5 = putObjectResult.getContentMd5();
//				return contentMd5;
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		}

public byte[] downloadFile(String filename) {
		S3Object object = s3.getObject(bucketName, filename);
		S3ObjectInputStream objectContent = object.getObjectContent();
		try {
			return IOUtils.toByteArray(objectContent);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	public String deleteFile(String filename) {

		s3.deleteObject(bucketName, filename);
		return "File deleted";
	}

	public List<String> listAllFiles() {

		ListObjectsV2Result listObjectsV2Result = s3.listObjectsV2(bucketName);
		return listObjectsV2Result.getObjectSummaries().stream().map(S3ObjectSummary::getKey)
				.collect(Collectors.toList());

	}

//	private File convertMultiPartToFile(MultipartFile file) throws IOException {
//		File convFile = new File(file.getOriginalFilename());
//		FileOutputStream fos = new FileOutputStream(convFile);
//		fos.write(file.getBytes());
//		fos.close();
//		return convFile;
//	}

}
