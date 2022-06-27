package webrixtec.service;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpRequest;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.*;

import webrixtec.exptionHandling.ExceptionController;
import webrixtec.model.getResumeApiEntity;
import webrixtec.repo.GetResumeApiRepo;

@Service
public class getResumeApiService extends ExceptionController {
	@Autowired
	GetResumeApiRepo resRepo;
	
	  private AmazonS3 s3client;
	
//	 private Logger logger = LoggerFactory.getLogger(getResumeApiService.class);
	
//	@Value("${image.filepath}")
//	String dir;
	@Autowired
	FileStorageService FileStorageService;
	public ResponseEntity<Object> addResumeDetails(getResumeApiEntity value) throws IOException {
		boolean EmailExists = resRepo.existsByEmail(value.getEmail());
		boolean phoneExists = resRepo.existsByPhone(value.getPhone());
		if (EmailExists) {
			return failure(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
					" Email Id already exists");
		} else if (phoneExists) {
			return failure(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
					"Mobile Number already exists");
		}
		if (value.getMfile()==null) {
			return failure(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
					" mfile is null");
		}
		// local save Images
//		String f = Path.of(dir, value.getMfile().getOriginalFilename()).toString();
//		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(f)));
//		stream.write(value.getMfile().getBytes());
//		stream.close();
//		obj.setFileUrl(f);
		getResumeApiEntity obj = new getResumeApiEntity();
		
		obj.setFileUrl(FileStorageService.uploadFile(value.getMfile(),"resume"));
		obj.setEmail(value.getEmail());
		obj.setCompany(value.getCompany());
		obj.setName(value.getName());
		obj.setPhone(value.getPhone());
		obj.setDate(new Date());
		resRepo.save(obj);
		return response(HttpStatus.OK.value(), "Resume added Succcessfully", obj);
	}

	public ResponseEntity<Object> getAllResumeDetail() {
		// TODO Auto-generated method stub
		List<getResumeApiEntity> obj = resRepo.findAll();
		Collections.reverse(obj);
		return response(HttpStatus.OK.value(), "Resume", obj);
	}

	public ResponseEntity<Object> updateResumeDetail(getResumeApiEntity value) throws IOException {
		boolean IdNotExists = resRepo.existsById(value.getId());
		if (!IdNotExists) {
			return failure(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
					" User Id is Null !");
		}
		getResumeApiEntity obj = resRepo.findById(value.getId()).get();
		if (obj == null) {
			return failure(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
					" User Id Not exists");
		}

		// local save Images
//		String f = Path.of(dir, value.getMfile().getOriginalFilename()).toString();
//		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(f)));
//		stream.write(value.getMfile().getBytes());
//		stream.close();
//		obj.setFileUrl(f);
		
		
		obj.setFileName(FileStorageService.generateFileName(value.getMfile()));
		obj.setFileUrl(FileStorageService.uploadFile(value.getMfile(),"resume"));
		obj.setEmail(value.getEmail());
		obj.setCompany(value.getCompany());
		obj.setName(value.getName());
		obj.setPhone(value.getPhone());
		resRepo.save(obj);
		return response(HttpStatus.OK.value(), "Resume Updated Succcessfully", obj);
	}

	public ResponseEntity<Object> deleteResumeDetail(int id) {
		getResumeApiEntity obj = resRepo.findById(id).get();
		if (obj == null) {
			return failure(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
					"Please check the Client details");
		}
		resRepo.delete(obj);
		return response(HttpStatus.OK.value(), "Resume deleted successfully");
	}
	
	 public ByteArrayOutputStream downloadFile(String keyName) {
	        try {
	            S3Object s3object = s3client.getObject(new GetObjectRequest("hrsite", keyName));

	            InputStream is = s3object.getObjectContent();
	            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	            int len;
	            byte[] buffer = new byte[4096];
	            while ((len = is.read(buffer, 0, buffer.length)) != -1) {
	                outputStream.write(buffer, 0, len);
	            }

	            return outputStream;
	        } catch (IOException ioException) {
	        	System.out.println("IOException: " + ioException.getMessage());
	        } catch (AmazonServiceException serviceException) {
	        	System.out.println("AmazonServiceException Message:    " + serviceException.getMessage());
	            throw serviceException;
	        } catch (AmazonClientException clientException) {
	            System.out.println("AmazonClientException Message: " + clientException.getMessage());
	            throw clientException;
	        }

	        return null;
	    }
	
}
