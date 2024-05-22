package com.demo.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.employee.dto.APIResponseDTO;
import com.demo.employee.dto.EmployeeDTO;
import com.demo.employee.service.EmployeeService;

@RestController
@RequestMapping("api/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/save-emp")
	public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
		return ResponseEntity.ok(employeeService.saveEmployee(employeeDTO));
	}
	
	@GetMapping("/get/{name}")
	public List<EmployeeDTO> findByEmpName(@PathVariable String name) {
		return employeeService.findByEmpName(name);
	}
	
	@GetMapping("/empdetails/{id}")
	public ResponseEntity<APIResponseDTO> findByid(@PathVariable Long id) {
		return ResponseEntity.ok(employeeService.getEmpById(id));
	}

}
