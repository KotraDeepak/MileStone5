package com.CustomerInfo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CustomerInfo.Entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

	Object getAllCustomer();
	Object addNewCustomer(Customer c1);
	
	

}
