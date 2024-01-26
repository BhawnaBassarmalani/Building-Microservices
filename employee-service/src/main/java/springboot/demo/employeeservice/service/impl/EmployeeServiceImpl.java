package springboot.demo.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import springboot.demo.employeeservice.dto.APIResponseDto;
import springboot.demo.employeeservice.dto.DepartmentDto;
import springboot.demo.employeeservice.dto.EmployeeDto;
import springboot.demo.employeeservice.entity.Employee;
import springboot.demo.employeeservice.repository.EmployeeRepository;
import springboot.demo.employeeservice.service.EmployeeService;
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    private RestTemplate restTemplate;
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto = new EmployeeDto(
                savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail(),
                savedEmployee.getDepartmentCode()
        );
        return savedEmployeeDto;
    }

    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
//       ResponseEntity<DepartmentDto>responseEntity =  restTemplate.getForEntity
//               ("http://localhost:7990/api/departments/",+employee.getDepartmentCode(DepartmentDto.class);

        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity(
                "http://localhost:7990/api/departments/" + employee.getDepartmentCode(),
                DepartmentDto.class
        );

               DepartmentDto departmentDto = responseEntity.getBody();
        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }

}
