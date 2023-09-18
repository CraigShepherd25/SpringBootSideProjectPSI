package com.example.demo.testing;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Purchase;
import com.example.demo.repository.PurchaseRepository;

@SpringBootTest
public class QueryPurchase {
	
	@Autowired
	PurchaseRepository purchaseRepository;
	
	@Test
	public void test() {
		
		List<Purchase> purchases = purchaseRepository.findAll();
		
		purchases.forEach(purchase -> {
			System.out.printf("採購單編號: %d 採購人員 %s 供應商名稱 %s\n", 
					purchase.getId(), purchase.getEmployee().getName(), purchase.getSupplier().getName());
			System.out.printf("採購單明細:\n");
			purchase.getPurchaseItems().forEach(item -> {
				System.out.printf("\t明細編號 %d 商品名稱 %s 採購數量 %d \n", 
					item.getId(), item.getProduct().getName(), item.getAmount());
			});
			System.out.println("---------------------------------------");
		});
		
	}
}
