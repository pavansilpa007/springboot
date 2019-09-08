package com.test.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.DTO.ResponseDTO;
import com.test.app.model.Employee;
import com.test.app.service.ProductService;

@Controller
public class AppController {

	@Autowired
	private ProductService service; 
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Employee> listEmployees = service.listAll();
		model.addAttribute("listEmployees", listEmployees);
		
		return "index";
	}
	
	@CrossOrigin(origins = "http://localhost:2020")
	@PostMapping("/createEmployee")
	public ResponseEntity<Object> showNewProductPage(@RequestBody Employee employee) {
		service.save(employee);
		
		return new ResponseEntity<Object>(new ResponseDTO("success", null, null), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:2020")
	@GetMapping("/employeeDetails")
	public ResponseEntity<Object> getEmolpyeeDetails(Model model) {
		List<Employee> listEmployees = service.listAll();
		
		return new ResponseEntity<Object>(new ResponseDTO("success", null, listEmployees), HttpStatus.OK);
	}
}
