package com.example.demo.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;

@Entity
@Table(name = "supplier")
public class Supplier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // 供應商序號
	
	@Column
	private String name; // 供應商名稱
	
	@OneToMany(mappedBy = "supplier")
	@OrderBy("id ASC")
	private Set<Purchase> purchases = new LinkedHashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(Set<Purchase> purchases) {
		this.purchases = purchases;
	}
	
	
}
