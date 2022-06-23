package com.carmatask.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.carmatask.model.Customer;
import com.carmatask.repo.CustomerRepository;

@Named
@ViewScoped
public class CustomerController {

	@Autowired
	private CustomerRepository repo;
	
	private List<Customer> customers;
	
	private Customer customer= new Customer();
	
	 private boolean makeEdit= false;
	
	
	@PostConstruct
	public void init() {
	customers= repo.lstAll();
	}

	public void save() {
       repo.save(getCustomer());
     
	if(!makeEdit)
       customers.add(customer);
		customer= new Customer();
	}
	
	public void edit(Customer customer) {
		setCustomer(customer);
		makeEdit=true;
	}
	
	
	
	
	public void cancel() {
		customer = new Customer();
		makeEdit=false;
	}
	
	public void delete(Customer customer) {
		repo.delete(customer);
		customers.remove(customer);
	}
	
	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public boolean isMakeEdit() {
		return makeEdit;
	}

	public void setMakeEdit(boolean makeEdit) {
		this.makeEdit = makeEdit;
	}


	
}
