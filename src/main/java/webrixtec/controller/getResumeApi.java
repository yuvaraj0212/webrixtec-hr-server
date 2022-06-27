package webrixtec.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import webrixtec.model.getResumeApiEntity;
import webrixtec.service.getResumeApiService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api-resume")
public class getResumeApi {
	@Autowired
	getResumeApiService resService;


   
	
	@PostMapping(value = "/add-resume")
	public ResponseEntity<Object> addResumeDetail( getResumeApiEntity obj) throws IOException {
		return resService.addResumeDetails(obj);
	}
	
	
	@GetMapping(value = "/get-resume-all")
	public ResponseEntity<Object> getAllResumeDetail() {
		return resService.getAllResumeDetail();
	}
	
	@PostMapping(value = "/update-resume")
	public ResponseEntity<Object> updateResumeDetail( getResumeApiEntity obj) throws IOException {
		return resService.updateResumeDetail(obj);
	}
	
	@GetMapping(value = "/delete-resume")
	public ResponseEntity<Object> deleteResumeDetail(@RequestParam (value="id")int id) {
		return resService.deleteResumeDetail(id);
	}
	
	 @GetMapping(value = "/download/{filename}")
	    public ResponseEntity<byte[]> downloadFile(@PathVariable String filename) {
	        ByteArrayOutputStream downloadInputStream = resService.downloadFile(filename);

	        return ResponseEntity.ok()
	                .contentType(contentType(filename))
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
	                .body(downloadInputStream.toByteArray());
	    }
	    
	    private MediaType contentType(String filename) {
	        String[] fileArrSplit = filename.split("\\.");
	        String fileExtension = fileArrSplit[fileArrSplit.length - 1];
	        switch (fileExtension) {
	            case "txt":
	                return MediaType.TEXT_PLAIN;
	            case "png":
	                return MediaType.IMAGE_PNG;
	            case "jpg":
	                return MediaType.IMAGE_JPEG;
	            default:
	                return MediaType.APPLICATION_OCTET_STREAM;
	        }
	    }

}
