package com.example.employee.employee.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.employee.Mapper.EmployeeMapper;
import com.example.employee.employee.Model.Employee;


@RestController
@RequestMapping("/spring_demo/employee")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class EmployeeResource {
	
	@Autowired
	private EmployeeMapper employeemapper;
	@GetMapping("/all")
	public List<Employee> getAll()
	{
		return employeemapper.findAll();
	}
	@GetMapping("/all/{id}")
	public Employee getById(@PathVariable(value="id")int id)
	{
		return employeemapper.getById(id);
	}
	@PostMapping("/employee")
	public void createEmployee(@RequestBody Employee employe)
	{
		employeemapper.insert(employe);
	}
	@PutMapping("/update/{id}")
     public void updateEmployee(@PathVariable(value = "id") int id,
    		 @RequestBody Employee employeeDetails)
     {
		
		employeemapper.update(employeeDetails);
     }
	
	@DeleteMapping("/employee/{id}")
	public void deleteEmployee(@PathVariable(value = "id") int employeeId)
	{
		Employee e=employeemapper.getById(employeeId);
		employeemapper.delete(e);
	}
}
