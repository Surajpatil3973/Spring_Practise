package com.tka.Employee_Crud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.Employee_Crud.entity.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	SessionFactory factory;

	public String insertData(Employee e) { // insert data

		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();

		ss.persist(e);
		tr.commit();
		ss.close();
		return "record is Set";
	}

	public String DeleteData(int id) { // delete data
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		Employee e = ss.get(Employee.class, id);
		ss.remove(e);
		tr.commit();
		ss.close();
		return "data is deleted sucessfully";
	}

	public String updateData(Employee e, int id) { // update data
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		Employee edd = ss.get(Employee.class, id);
		edd.setName(e.getName());
		edd.setName(e.getName());

		ss.merge(edd);
		tr.commit();
		ss.close();
		return "data is updated";
	}

	public List<Employee> getAllRecords() { // get all record
		Session ss = factory.openSession();
		List<Employee> employee = ss.createQuery("from Employee", Employee.class).list();
		ss.close();
		return employee;
	}

	public Employee getSingleRecord(int id) { // get single record
		Session ss = factory.openSession();
		Employee s = ss.get(Employee.class, id);
		ss.close();
		return s;
	}

}
