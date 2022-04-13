package webrixtec.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import webrixtec.model.resumeModel;
import webrixtec.service.resumeSrevice;

@RestController
public class resumecontroller {
	@Autowired
	resumeSrevice ResumeService;
	

	@GetMapping(value = "hello")
	public String helloworld() {
		return "hello world";
	}

	@PostMapping(value = "/addfile")
	public List<Map<String, String>> add(MultipartFile excel) throws Exception {
		return ResumeService.addexcelsheet(excel);
	}
	
	@GetMapping(value = "/get-all-resume")
	public List<resumeModel> getresume() throws Exception {
		return ResumeService.getresume();
	}
}
