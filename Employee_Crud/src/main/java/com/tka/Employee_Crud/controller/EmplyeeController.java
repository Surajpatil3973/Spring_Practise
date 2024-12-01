package com.tka.Employee_Crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.Employee_Crud.entity.Employee;
import com.tka.Employee_Crud.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmplyeeController {
	
	@Autowired
	EmployeeService service;
	
	@PostMapping("/savedata")
	public String insertData(@RequestBody Employee e) {
		String msg = service.InsertData(e);
		return msg;
	}

	@DeleteMapping("/deletedata/{id}")
	public String deleteData(@PathVariable int id) {
		String msg = service.DeleteData(id);
		return msg;
	}

	@PutMapping("/updatedata/{id}")
	public String updateData(@PathVariable int id, @RequestBody Employee e) {
		String msg = service.updateData(e, id);
		return msg;
	}

	@GetMapping("/getallrecords")
	public List<Employee> getAllRecords() {
		return service.getAllRecords();
	}

	@GetMapping("/getrecord/{id}")
	public Employee getSingleRecord(@PathVariable int id) {
		Employee employee = service.getSingleRecord(id);
		return employee;
	}
	

}
