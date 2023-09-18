package com.example.demo.testing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@SpringBootTest
public class CreateCustomer {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Test
	public void test() {
		Customer c1 = new Customer();
		c1.setName("劉一");
		
		Customer c2 = new Customer();
		c2.setName("陳二");
		
		Customer c3 = new Customer();
		c3.setName("張三");
		
		Customer c4 = new Customer();
		c4.setName("李四");
		
		Customer c5 = new Customer();
		c5.setName("王五");
		
		Customer c6 = new Customer();
		c6.setName("趙六");
		
		Customer c7 = new Customer();
		c7.setName("孫七");
		
		Customer c8 = new Customer();
		c8.setName("周八");
		
		Customer c9 = new Customer();
		c9.setName("吳九");
		
		Customer c10 = new Customer();
		c10.setName("鄭十");
		
		// 儲存
		customerRepository.save(c1);
		customerRepository.save(c2);
		customerRepository.save(c3);
		customerRepository.save(c4);
		customerRepository.save(c5);
		customerRepository.save(c6);
		customerRepository.save(c7);
		customerRepository.save(c8);
		customerRepository.save(c9);
		customerRepository.save(c10);
		
		System.out.println("OK");
	}
	
}
