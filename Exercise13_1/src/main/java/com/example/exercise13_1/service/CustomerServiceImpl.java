package com.example.exercise13_1.service;

import com.example.exercise13_1.dao.CustomerDAOService;
import com.example.exercise13_1.jms.EmailSenderService;
import com.example.exercise13_1.domain.Address;
import com.example.exercise13_1.domain.Customer;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDAOService customerDAO;
	private EmailSenderService emailSender;

	public void setCustomerDAO(CustomerDAOService customerDAO) {
		this.customerDAO = customerDAO;
	}

	public void setEmailSender(EmailSenderService emailSender) {
		this.emailSender = emailSender;
	}

	public void addCustomer(String name, String email, String street,
			String city, String zip) {
		Customer customer = new Customer(name, email);
		Address address = new Address(street, city, zip);
		customer.setAddress(address);
		customerDAO.save(customer);
		emailSender.sendEmail(email, "Welcome " + name + " as a new customer");
	}
}
