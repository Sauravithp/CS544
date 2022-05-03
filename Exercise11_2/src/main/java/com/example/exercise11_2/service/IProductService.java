package com.example.exercise11_2.service;

import com.example.exercise11_2.domain.Product;

public interface IProductService {
	 Product getProduct(int productNumber);

	Integer getNumberInStock(Integer number);
}
