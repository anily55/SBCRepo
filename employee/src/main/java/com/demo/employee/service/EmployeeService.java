package com.demo.employee.service;

import java.util.List;

import com.demo.employee.dto.APIResponseDTO;
import com.demo.employee.dto.EmployeeDTO;

public interface EmployeeService {
	EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
	
	List<EmployeeDTO> findByEmpName(String name);
	
	APIResponseDTO getEmpById(Long id);
}
