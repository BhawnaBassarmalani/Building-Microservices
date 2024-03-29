package springboot.demo.employeeservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.demo.employeeservice.dto.APIResponseDto;
import springboot.demo.employeeservice.dto.EmployeeDto;
import springboot.demo.employeeservice.service.EmployeeService;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;
@PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
       EmployeeDto savedEmployee=  employeeService.saveEmployee(employeeDto);
       return new ResponseEntity<>(savedEmployee , HttpStatus.CREATED);

    }

    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id") Long employeeId){
    APIResponseDto apiResponseDto= employeeService.getEmployeeById(employeeId);
    return new ResponseEntity<>(apiResponseDto,HttpStatus.OK);
    }

}
