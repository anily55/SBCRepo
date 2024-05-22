package com.demo.employee.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.demo.employee.dto.DepartmentDTO;

@FeignClient(url = "http://localhost:5252", value = "Department")
public interface APIClient {

	@GetMapping("/api/dept/{deptcode}")
	public DepartmentDTO getDepartmentByDeptCode(@PathVariable String deptcode);
}
