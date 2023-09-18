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
public class CreateOrder2 {
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
		// Sales 部門 Bob, 訂單客戶: 陳二 訂單明細: 百合花 25 朵 鬱金香 35 朵 玫瑰 45 向日葵 55
		Employee emp = employeeRepository.findById(4L).get(); // Bob
		Customer customer = customerRepository.findById(2L).get(); // 陳二
		Product p1 = productRepository.findById(1L).get(); // 百合花
		Product p2 = productRepository.findById(2L).get(); // 鬱金香
		Product p3 = productRepository.findById(3L).get(); // 玫瑰
		Product p4 = productRepository.findById(4L).get(); // 向日葵
		
		// 建立訂單
		Order order = new Order();
		order.setDate(new Date()); // 建立訂單日期
		// 配置關聯
		order.setEmployee(emp); // 配置員工: Bob
		order.setCustomer(customer); // 配置客戶: 陳二
		
		// 建立訂單明細 1
		OrderItem item1 = new OrderItem();
		item1.setAmount(25); // 購買數量: 25
		// 配置關聯
		item1.setOrder(order); // 配置訂購單
		item1.setProduct(p1);  // 配置商品 p1
		
		// 建立訂單明細 2
		OrderItem item2 = new OrderItem();
		item2.setAmount(35); // 購買數量: 35
		// 配置關聯
		item2.setOrder(order); // 配置訂購單
		item2.setProduct(p2);  // 配置商品 p2
		
		// 建立訂單明細 3
		OrderItem item3 = new OrderItem();
		item3.setAmount(45); // 購買數量: 45
		// 配置關聯
		item3.setOrder(order); // 配置訂購單
		item3.setProduct(p3);  // 配置商品 p3
		
		// 建立訂單明細 4
		OrderItem item4 = new OrderItem();
		item4.setAmount(55); // 購買數量: 55
		// 配置關聯
		item4.setOrder(order); // 配置訂購單
		item4.setProduct(p4);  // 配置商品 p4
				
		// 保存
		orderRepository.save(order);
		orderItemRepository.save(item1);
		orderItemRepository.save(item2);
		orderItemRepository.save(item3);
		orderItemRepository.save(item4);
		
		System.out.println("OK");
	}
	
}