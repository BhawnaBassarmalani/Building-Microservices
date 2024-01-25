package springboot.demo.employeeservice.service;

import springboot.demo.employeeservice.dto.EmployeeDto;

public interface EmployeeService {


    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);
}
