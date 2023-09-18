package com.example.demo.testing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;

@SpringBootTest
public class CreateEmployee {
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Test
	public void test() {
		// 先取得部門
		Department d1 = departmentRepository.findById(1L).get();
		Department d2 = departmentRepository.findById(2L).get();
		Department d3 = departmentRepository.findById(3L).get();
		
		// 建立員工 
		Employee e1 = new Employee("John");
		Employee e2 = new Employee("Mary");
		Employee e3 = new Employee("Helen");
		Employee e4 = new Employee("Bob");
		Employee e5 = new Employee("Jack");
		Employee e6 = new Employee("Rose");
		
		// 配置關聯(員工與部門的關係)
		// 由多(Employee)的一(Department)方來維護關聯
		e1.setDepartment(d1);
		e2.setDepartment(d2);
		e3.setDepartment(d3);
		e4.setDepartment(d1);
		e5.setDepartment(d2);
		e6.setDepartment(d3);
		
		// 保存
		employeeRepository.save(e1);
		employeeRepository.save(e2);
		employeeRepository.save(e3);
		employeeRepository.save(e4);
		employeeRepository.save(e5);
		employeeRepository.save(e6);
		
		System.out.println("OK");
	}
	
}
