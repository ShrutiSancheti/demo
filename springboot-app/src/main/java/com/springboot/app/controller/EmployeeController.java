package com.springboot.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.model.Employee;
import com.springboot.app.service.EmployeeService;
import com.example.demo.base.api.EmployeeApi;

@RestController
public class EmployeeController implements EmployeeApi{
	
	@Autowired
	EmployeeService empService;
	
	@Override
	public ResponseEntity<Void> addEmployee(com.example.demo.base.api.model.@Valid Employee employee) {
		// TODO Auto-generated method stub
		return empService.addEmployee(employee);
	}
	
	@Override
	public ResponseEntity<List<com.example.demo.base.api.model.Employee>> getAllEmployee() {
		// TODO Auto-generated method stub
		return empService.getAllEmployee();
	}
	
	@Override
	public ResponseEntity<Void> editEmployee(com.example.demo.base.api.model.@Valid Employee employee) {
		// TODO Auto-generated method stub
		return empService.editEmployee(employee);
	}
	
	@Override
	public ResponseEntity<Void> deleteEmployee(Integer employeeId) {
		// TODO Auto-generated method stub
		return empService.deleteEmployee(employeeId);
	}
//	@PutMapping("/edit")
//	public String edit(@RequestBody Employee emp) throws Exception{
//		return empService.edit(emp);
//	}
//	
//	@DeleteMapping("/delete")
//	public String delete(@RequestParam String id) throws Exception{
//		return empService.delete(id);
//	}
}
