package com.springboot.app.adapter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.app.model.Employee;

@Repository
public class EmployeeAdapter {

	public List<Employee> emp=new ArrayList<Employee>();

	public String edit(List<Employee> emp2) throws Exception {
		ObjectMapper Obj = new ObjectMapper();
		FileWriter f = new FileWriter("H:\\employee.txt");
        BufferedWriter b = new BufferedWriter(f);
        PrintWriter p = new PrintWriter(b);
        p.println("["+Obj.writeValueAsString(emp2.get(0)));
		for(int i=1;i<emp2.size();i++) {
			p.println(","+Obj.writeValueAsString(emp2.get(i)));
		}
		p.close();
        b.close();
        f.close();
		
		return "Successfully Added";
	}

	public String delete(List<Employee> emp2) throws Exception {
		ObjectMapper Obj = new ObjectMapper();
		FileWriter f = new FileWriter("H:\\employee.txt");
        BufferedWriter b = new BufferedWriter(f);
        PrintWriter p = new PrintWriter(b);
        p.println("["+Obj.writeValueAsString(emp2.get(0)));
		for(int i=1;i<emp2.size();i++) {
			p.println(","+Obj.writeValueAsString(emp2.get(i)));
		}
		p.close();
        b.close();
        f.close();
		return "Successfully deleted";
	}

	
	public ResponseEntity<List<com.example.demo.base.api.model.Employee>> getAllEmployee() {
		// TODO Auto-generated method stub
		List<com.example.demo.base.api.model.Employee> ep=new ArrayList();
		try {
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
			com.example.demo.base.api.model.Employee e1=new com.example.demo.base.api.model.Employee();
			e1.setId(temp.getInt("id")); //start setting the values for your node...
		    e1.setName(temp.getString("name"));
		    e1.setSalary(temp.getInt("salary"));
		    ep.add(e1);
		}
		}
		catch(Exception ex) {
			
		}
		return new ResponseEntity<List<com.example.demo.base.api.model.Employee>>(ep, HttpStatus.OK);
	}

	public ResponseEntity<Void> addEmployee(com.example.demo.base.api.model.@Valid Employee employee) {
		// TODO Auto-generated method stub
		try {
		FileWriter f = new FileWriter("H:\\employee.txt", true);
        BufferedWriter b = new BufferedWriter(f);
        PrintWriter p = new PrintWriter(b);

        StringBuilder sb = new StringBuilder();
        sb.append(",{");
        sb.append("\"id\":");
        sb.append(employee.getId());
        sb.append(", \"name\":\"");
        sb.append(employee.getName());
        sb.append("\", \"salary\":");
        sb.append(employee.getSalary());
        sb.append("}");
        p.println(sb.toString());
        p.close();
        b.close();
        f.close();}
		catch(Exception e) {
			
		}
		return null;
	} 
}
