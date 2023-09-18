package com.example.demo.testing;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Product;
import com.example.demo.entity.Purchase;
import com.example.demo.entity.PurchaseItem;
import com.example.demo.entity.Supplier;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.PurchaseItemRepository;
import com.example.demo.repository.PurchaseRepository;
import com.example.demo.repository.SupplierRepository;

@SpringBootTest
public class CreatePurchase2 {
	@Autowired
	SupplierRepository supplierRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	PurchaseRepository purchaseRepository;
	
	@Autowired
	PurchaseItemRepository purchaseItemRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Test
	public void test() {
		// 資料預備
		// Purchase 部門的員工 Helen 對 供應商瑞士花園 採購 玫瑰80朵 與 向日葵150朵
		Employee emp = employeeRepository.findById(3L).get(); // Helen
		Supplier sup = supplierRepository.findById(2L).get(); // 瑞士花園
		Product p1 = productRepository.findById(3L).get(); // 玫瑰
		Product p2 = productRepository.findById(4L).get(); // 向日葵
		
		// 建立採購單
		Purchase purchase = new Purchase();
		purchase.setDate(new Date()); // 建立採購單日期(今日)
		
		// 配置關聯
		purchase.setSupplier(sup); // 配置供應商(瑞士花園)
		purchase.setEmployee(emp); // 配置員工(Helen);
		
		// 建立採購單明細 1
		// 玫瑰 80 朵
		PurchaseItem item1 = new PurchaseItem();
		item1.setAmount(80); // 80 朵
		// 配置關聯
		item1.setPurchase(purchase); // 採購單明細關連到採購單
		item1.setProduct(p1); // // 採購單明細關連到商品(玫瑰)
		
		// 建立採購單明細 2
		// 向日葵 150 朵
		PurchaseItem item2 = new PurchaseItem();
		item2.setAmount(150); // 150 朵
		// 配置關聯
		item2.setPurchase(purchase); // 採購單明細關連到採購單
		item2.setProduct(p2); // // 採購單明細關連到商品(向日葵)
		
		// 保存採購單與採購單明細
		purchaseRepository.save(purchase); // 採購單(主檔)
		purchaseItemRepository.save(item1); // 採購單明細(明細檔)
		purchaseItemRepository.save(item2); // 採購單明細(明細檔)
		
		System.out.println("OK");
	}
	
}
