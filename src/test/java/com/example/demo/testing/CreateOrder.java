package com.example.demo.testing;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItem;
import com.example.demo.entity.Product;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.OrderItemRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;

@SpringBootTest
public class CreateOrder {
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Test
	public void test() {
		// 資料預備
		// Sales 部門 John, 訂單客戶: 劉一 訂單明細: 百合花 15 朵 鬱金香 12 朵
		Employee emp = employeeRepository.findById(1L).get(); // John
		Customer customer = customerRepository.findById(1L).get(); // 劉一
		Product p1 = productRepository.findById(1L).get(); // 百合花
		Product p2 = productRepository.findById(2L).get(); // 鬱金香
		
		// 建立訂單
		Order order = new Order();
		order.setDate(new Date()); // 建立訂單日期
		// 配置關聯
		order.setEmployee(emp); // 配置員工: John
		order.setCustomer(customer); // 配置客戶: 劉一
		
		// 建立訂單明細 1
		OrderItem item1 = new OrderItem();
		item1.setAmount(15); // 購買數量: 15
		// 配置關聯
		item1.setOrder(order); // 配置訂購單
		item1.setProduct(p1);  // 配置商品 p1
		
		// 建立訂單明細 2
		OrderItem item2 = new OrderItem();
		item2.setAmount(12); // 購買數量: 12
		// 配置關聯
		item2.setOrder(order); // 配置訂購單
		item2.setProduct(p2);  // 配置商品 p2
				
		// 保存
		orderRepository.save(order);
		orderItemRepository.save(item1);
		orderItemRepository.save(item2);
		
		System.out.println("OK");
	}
	
}