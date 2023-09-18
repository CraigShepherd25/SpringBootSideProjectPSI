package com.example.demo.testing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Purchase;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.PurchaseRepository;

@SpringBootTest
public class UpdatePurchaseEmployee {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	PurchaseRepository purchaseRepository;
	
	@Test
	public void test() {
		// 將 1L 採購單的員工改為Rose(6L)
		// 取得員工
		Employee emp = employeeRepository.findById(6L).get();
		
		// 取得採購單
		Purchase purchase = purchaseRepository.findById(1L).get();
		
		// 重新配置關聯 
		purchase.setEmployee(emp);
		
		// 保存
		purchaseRepository.save(purchase);
		
		System.out.println("OK");
	}
	
}
