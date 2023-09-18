package com.example.demo.testing;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Order;
import com.example.demo.repository.OrderRepository;

@SpringBootTest
public class QueryOrder {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Test
	public void test() {
		// 查詢所有訂單與明細
		// 訂單id, 客戶姓名, 員工姓名, 總價, (主檔)
		// 明細id, 商品名稱, 數量, 單價, 小計 (明細)
		List<Order> orders = orderRepository.findAll();
		
		orders.forEach(order -> {
			// 計算該筆訂單的總價
			int total = order.getOrderItems()
	  				  .stream()
					  .mapToInt(item -> item.getAmount() * item.getProduct().getPrice())
					  .sum();
			
			System.out.printf("訂單ID: %d 客戶: %s 員工: %s 總價: %,d\n", 
					order.getId(), order.getCustomer().getName(), order.getEmployee().getName(), total);
			System.out.println("訂單明細:");
			order.getOrderItems().forEach(item -> {
				System.out.printf("明細ID: %d 商品名稱: %s 數量: %d 單價: %,d 小計: %d\n",
						item.getId(), item.getProduct().getName(), item.getAmount(),
						item.getProduct().getPrice(),
						(item.getProduct().getPrice() * item.getAmount()));
			});
			System.out.println("------------------------------------------------");
		});
		
		// 所有訂單的總價
		int sumTotal = orders.stream()
				  .mapToInt(order -> order.getOrderItems()
						  				  .stream()
										  .mapToInt(item -> item.getAmount() * item.getProduct().getPrice())
										  .sum())
				  .sum(); 
		System.out.printf("所有訂單的總價: %,d\n", sumTotal);
		
	}
}
