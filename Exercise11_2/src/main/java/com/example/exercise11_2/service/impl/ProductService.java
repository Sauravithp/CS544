package com.example.exercise11_2.service.impl;

import com.example.exercise11_2.domain.Product;
import com.example.exercise11_2.service.IProductService;
import com.example.exercise11_2.service.InventoryService;

import java.util.ArrayList;
import java.util.Collection;

public class ProductService implements IProductService {
	private Collection<Product> productList = new ArrayList<Product>();
	private InventoryService inventoryService;


//	public ProductService(InventoryService inventoryService) {
//		productList.add(new Product(234, "LCD TV", 895.50));
//		productList.add(new Product(239, "DVD player", 315.00));
//		productList.add(new Product(423, "Plasma TV", 992.55));
//		this.inventoryService=inventoryService;
//	}

	public ProductService() {
		productList.add(new Product(234, "LCD TV", 895.50));
		productList.add(new Product(239, "DVD player", 315.00));
		productList.add(new Product(423, "Plasma TV", 992.55));
	}

	public Product getProduct(int productNumber) {
		for (Product product : productList) {
			if (product.getProductNumber() == productNumber)
				return product;
		}
		return null;
	}

	@Override
	public Integer getNumberInStock(Integer number) {
       return inventoryService.getNumberInStock(number);
	}

	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}



}
