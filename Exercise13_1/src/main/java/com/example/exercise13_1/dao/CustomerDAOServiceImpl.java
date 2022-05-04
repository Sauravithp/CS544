package com.example.exercise13_1.dao;

import com.example.exercise13_1.domain.Customer;

public class CustomerDAOServiceImpl implements CustomerDAOService {
	
	public void save(Customer customer) {
		try {
			Thread.sleep(350);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("CustomerDAO: saving customer "+customer.getName());
	}

}
