package com.springboot.app.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.app.model.Employee;
import com.springboot.app.adapter.EmployeeAdapter;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeAdapter empAdapter;

	public String edit(Employee emp) throws Exception{
		List<Employee> emp1=new ArrayList<Employee>();
		BufferedReader reader = new BufferedReader(new FileReader("H:\\employee.txt"));
		String json = "";
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = reader.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append("\n");
		        line = reader.readLine();
		    }
		    json = sb.toString();
		} finally {
		    reader.close();
		}
		json=json+"]";
	
		JSONArray json_arr = new JSONArray(json);

		for(int i=0; i<json_arr.length(); i++){ // loop through the nodes
			JSONObject temp = json_arr.getJSONObject(i);
			Employee e=new Employee();
			e.setId(temp.getInt("id")); //start setting the values for your node...
		    e.setName(temp.getString("name"));
		    e.setSalary(temp.getInt("salary"));
		    emp1.add(e);
		}
		emp1.stream().filter(e-> e.getId()==emp.getId()).forEach(e->{
			e.setName(emp.getName());
			e.setSalary(emp.getSalary());});
		
		empAdapter.edit(emp1);
		return "Edited";
	}

	public String delete(int id) throws Exception {
		List<Employee> emp1=new ArrayList<Employee>();
		BufferedReader reader = new BufferedReader(new FileReader("H:\\employee.txt"));
		String json = "";
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = reader.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append("\n");
		        line = reader.readLine();
		    }
		    json = sb.toString();
		} finally {
		    reader.close();
		}
		json=json+"]";
	
		JSONArray json_arr = new JSONArray(json);

		for(int i=0; i<json_arr.length(); i++){ // loop through the nodes
			JSONObject temp = json_arr.getJSONObject(i);
			Employee e=new Employee();
			e.setId(temp.getInt("id")); //start setting the values for your node...
		    e.setName(temp.getString("name"));
		    e.setSalary(temp.getInt("salary"));
		    emp1.add(e);
		}
		emp1.stream().filter(e-> e.getId()==id).forEach(e->{
			emp1.remove(e);
		});
		empAdapter.delete(emp1);
		return "Deleted";
	}

	public ResponseEntity<List<com.example.demo.base.api.model.Employee>> getAllEmployee() {
		// TODO Auto-generated method stub
		return empAdapter.getAllEmployee();
	}

	public ResponseEntity<Void> addEmployee(com.example.demo.base.api.model.@Valid Employee employee) {
		// TODO Auto-generated method stub
		return empAdapter.addEmployee(employee);
	}

	public ResponseEntity<Void> editEmployee(com.example.demo.base.api.model.@Valid Employee employee) {
		// TODO Auto-generated method stub
		try {
		List<Employee> emp1=new ArrayList<Employee>();
		BufferedReader reader = new BufferedReader(new FileReader("H:\\employee.txt"));
		String json = "";
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = reader.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append("\n");
		        line = reader.readLine();
		    }
		    json = sb.toString();
		} finally {
		    reader.close();
		}
		json=json+"]";
	
		JSONArray json_arr = new JSONArray(json);

		for(int i=0; i<json_arr.length(); i++){ // loop through the nodes
			JSONObject temp = json_arr.getJSONObject(i);
			Employee e=new Employee();
			e.setId(temp.getInt("id")); //start setting the values for your node...
		    e.setName(temp.getString("name"));
		    e.setSalary(temp.getInt("salary"));
		    emp1.add(e);
		}
		emp1.stream().filter(e-> e.getId()==employee.getId()).forEach(e->{
			e.setName(employee.getName());
			e.setSalary(employee.getSalary());});
		
		empAdapter.edit(emp1);
		}
		catch(Exception e) {}
		return null;
	}

	public ResponseEntity<Void> deleteEmployee(Integer employeeId) {
		// TODO Auto-generated method stub
		try {
		List<Employee> emp1=new ArrayList<Employee>();
		BufferedReader reader = new BufferedReader(new FileReader("H:\\employee.txt"));
		String json = "";
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = reader.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append("\n");
		        line = reader.readLine();
		    }
		    json = sb.toString();
		} finally {
		    reader.close();
		}
		json=json+"]";
	
		JSONArray json_arr = new JSONArray(json);

		for(int i=0; i<json_arr.length(); i++){ // loop through the nodes
			JSONObject temp = json_arr.getJSONObject(i);
			Employee e=new Employee();
			e.setId(temp.getInt("id")); //start setting the values for your node...
		    e.setName(temp.getString("name"));
		    e.setSalary(temp.getInt("salary"));
		    emp1.add(e);
		}
		
		emp1.removeIf(e->e.getId()==employeeId);
		System.out.println(emp1.toString());

		empAdapter.delete(emp1);
	}
	catch(Exception e) {}
		return null;
	}

}
