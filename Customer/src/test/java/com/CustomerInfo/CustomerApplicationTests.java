package com.CustomerInfo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.CustomerInfo.Entity.Customer;
import com.CustomerInfo.Repo.CustomerRepo;



@SpringBootTest
class CustomerTest {
	
	@Autowired 
	private CustomerRepo CustomerRepo; 
	
	@MockBean 
	private CustomerRepo CustRepo; 
	
	@Test
	public void getAllCustomerTest() {
		when(CustRepo.findAll()).thenReturn(Stream.of(new Customer(1, "Deepak", "Male", 21, "veg"), new Customer(2, "Surya", "Female", 21, "nonveg")).collect(Collectors.toList()));
		assertEquals(2, ((Collection<Customer>) CustomerRepo.getAllCustomer()).size()); 
	}
	
	@Test
	public void addCustomerTest() {
		Customer c1=new Customer(1, "Deepak", "Male", 21, "veg"); 
		when(CustRepo.save(c1)).thenReturn(c1); 
		assertEquals(c1, CustomerRepo.addNewCustomer(c1));
	}

}
