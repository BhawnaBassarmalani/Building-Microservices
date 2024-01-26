package springboot.demo.employeeservice.service;

import springboot.demo.employeeservice.dto.APIResponseDto;
import springboot.demo.employeeservice.dto.DepartmentDto;
import springboot.demo.employeeservice.dto.EmployeeDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8001", value = "DEPARTMENT-SERVICE")
public interface APIClient {
    // Build get department rest api

    @GetMapping("api/departments/{department-code}")
   DepartmentDto getDepartment(@PathVariable("department-code") String departmentCode);

    }


