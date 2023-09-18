package com.example.demo.testing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@SpringBootTest
public class CreateProduct {
	@Autowired
	ProductRepository productRepository;
	
	@Test
	public void test() {
		Product p1 = new Product("百合花", 10, 10*4);
		Product p2 = new Product("鬱金香", 15, 15*4);
		Product p3 = new Product("玫瑰",  25, 25*4);
		Product p4 = new Product("向日葵", 35, 35*4);
		
		// 儲存
		productRepository.save(p1);
		productRepository.save(p2);
		productRepository.save(p3);
		productRepository.save(p4);
		
		System.out.println("OK");
		
	}
}
