package com.tka.Employee_Crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.Employee_Crud.dao.EmployeeDao;
import com.tka.Employee_Crud.entity.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao dao;

	public String InsertData(Employee e) {
		String msg = dao.insertData(e);
		return msg;
	}

	public String DeleteData(int id) {
		String msg = dao.DeleteData(id);
		return msg;
	}

	public String updateData(Employee e, int id) {
		String msg = dao.updateData(e, id);
		return msg;
	}

	public List<Employee> getAllRecords() {
		return dao.getAllRecords();
	}

	public Employee getSingleRecord(int id) {
		return dao.getSingleRecord(id);
	}
}
