package com.CustomerInfo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CustomerInfo.Entity.Customer;
import com.CustomerInfo.Repo.CustomerRepo;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@GetMapping("/allCustomers")
	public List<Customer> getAllEmployees() {
		return customerRepo.findAll();
	}
	
	@PostMapping("/addCustomers")
	public Customer createEmployee(@RequestBody Customer cust) {
		return customerRepo.save(cust);
	}

}
