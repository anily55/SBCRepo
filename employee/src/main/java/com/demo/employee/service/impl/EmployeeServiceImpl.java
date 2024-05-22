package com.demo.employee.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.employee.dto.APIResponseDTO;
import com.demo.employee.dto.DepartmentDTO;
import com.demo.employee.dto.EmployeeDTO;
import com.demo.employee.entity.Employee;
import com.demo.employee.repository.EmployeeRepository;
import com.demo.employee.service.APIClient;
import com.demo.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private APIClient apiClient;
	@Override
	public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
		Employee employee = employeeRepository.save(new Employee(null, employeeDTO.getName(), employeeDTO.getSalary(), employeeDTO.getDeptcode()));
		return new EmployeeDTO(employee.getId(), employee.getName(), employee.getSalary(), employee.getDeptcode());
	}
	@Override
	public List<EmployeeDTO> findByEmpName(String name) {
		return employeeRepository.findByNameIgnoreCase(name).stream().map(emp -> new EmployeeDTO(emp.getId(), emp.getName(), emp.getSalary(), emp.getDeptcode())).collect(Collectors.toList());
	}
	@Override
	public APIResponseDTO getEmpById(Long id) {
		Employee employee = employeeRepository.findById(id).get();
		DepartmentDTO department = apiClient.getDepartmentByDeptCode(employee.getDeptcode());
		return new APIResponseDTO(new EmployeeDTO(employee.getId(), employee.getName(), employee.getSalary(), employee.getDeptcode()), department);
	}
	
	

}
