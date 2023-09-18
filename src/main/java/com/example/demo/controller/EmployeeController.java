package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@GetMapping("/")
	public String index(@ModelAttribute Employee employee, Model model) {
		model.addAttribute("employees", employeeRepository.findAll());
		model.addAttribute("departments", departmentRepository.findAll());
		return "employee";
	}
	
	@PostMapping("/")
	public String create(Employee employee) {
		employeeRepository.save(employee);
		return "redirect:/employee/";
	}
	
	@GetMapping("/edit/{id}")  // 取得單筆資料為要呈現修改頁面 
	public String get(@PathVariable("id") Long id, Model model) {
		Employee employee = employeeRepository.findById(id).get();
		model.addAttribute("employee", employee);
		model.addAttribute("departments", departmentRepository.findAll());
		return "employee-edit";
	}
	
	@PutMapping("/{id}")
	public String update(@PathVariable("id") Long id, Employee employee) {
		employee.setId(id);
		employeeRepository.save(employee);
		return "redirect:/employee/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		employeeRepository.deleteById(id);
		return "redirect:/employee/"; 
	}
	
	
}