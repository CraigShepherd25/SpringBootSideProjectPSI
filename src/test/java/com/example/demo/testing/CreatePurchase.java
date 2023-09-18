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
public class CreatePurchase {
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
		// Sales 部門的員工 Bob 對 供應商富貴芬芳 採購 百合花100朵 與 鬱金香200朵
		Employee emp = employeeRepository.findById(4L).get(); // Bob
		Supplier sup = supplierRepository.findById(1L).get(); // 富貴芬芳
		Product p1 = productRepository.findById(1L).get(); //  百合花
		Product p2 = productRepository.findById(2L).get(); //  鬱金香
		
		// 建立採購單
		Purchase purchase = new Purchase();
		purchase.setDate(new Date()); // 建立採購單日期(今日)
		
		// 配置關聯
		purchase.setSupplier(sup); // 配置供應商(富貴芬芳)
		purchase.setEmployee(emp); // 配置員工(Bob);
		
		// 建立採購單明細 1
		// 百合花 100 朵
		PurchaseItem item1 = new PurchaseItem();
		item1.setAmount(100); // 100 朵
		// 配置關聯
		item1.setPurchase(purchase); // 採購單明細關連到採購單
		item1.setProduct(p1); // // 採購單明細關連到商品(百合花)
		
		// 建立採購單明細 2
		// 鬱金香200朵
		PurchaseItem item2 = new PurchaseItem();
		item2.setAmount(200); // 200 朵
		// 配置關聯
		item2.setPurchase(purchase); // 採購單明細關連到採購單
		item2.setProduct(p2); // // 採購單明細關連到商品(鬱金香)
		
		// 保存採購單與採購單明細
		purchaseRepository.save(purchase); // 採購單(主檔)
		purchaseItemRepository.save(item1); // 採購單明細(明細檔)
		purchaseItemRepository.save(item2); // 採購單明細(明細檔)
		
		System.out.println("OK");
	}
	
}
