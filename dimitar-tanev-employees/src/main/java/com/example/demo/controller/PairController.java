package com.example.demo.controller;

import java.io.IOException;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.EmployeesPair;
import com.example.demo.service.PairService;

@Controller
public class PairController {
	
	private EmployeesPair pair;
	private String errorMessage;
	
	@Autowired
	private PairService pairService;
	
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("employeesPair", pair);
		mv.addObject("errorMessage", errorMessage);
		mv.setViewName("index");
		return mv;
	}
	
	@PostMapping("/uploadFile")
	public String uploadFile(@RequestParam("file") MultipartFile file) {
		if(file.isEmpty()) {
			updateErrorMessage("Please select valid file.");
			return "redirect:/";
		}
		updateEmployeesPair(file);
		return "redirect:/";
		
	}

	private void updateErrorMessage(String message) {
		errorMessage = message;
		pair = null;
	}
	
	private void updateEmployeesPair(MultipartFile file) {
		try {
			pair = pairService.findLongestTeamPair(file.getInputStream());
			errorMessage = null;
		} catch (IOException e) {
			updateErrorMessage("File \"" + file.getOriginalFilename() + "\" is corrupted.");
		} catch (NumberFormatException | DateTimeParseException e) {
			updateErrorMessage("Data in file \"" + file.getOriginalFilename() + "\" is corruped.");
		}
	}

}
