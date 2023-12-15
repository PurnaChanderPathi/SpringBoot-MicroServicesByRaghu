package com.app.purna.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.purna.dto.CustomerRequest;
import com.app.purna.entity.Customer;
import com.app.purna.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class Controller {
	
	@Autowired
	private CustomerService customerService;

@PostMapping("/save")
public String saveCustomer(@RequestBody CustomerRequest customer)
{
	Customer saveCustomer = customerService.saveCustomer(customer);
	return saveCustomer.toString();
}

@GetMapping("/{id}")
public Customer findById(@PathVariable Long id)
{
return customerService.findById(id);
}

@GetMapping("/findByName/{name}")
public Optional<Customer> findByName(@PathVariable String name)
{
	return  customerService.findByName(name);
	 
}

@DeleteMapping("/{id}")
public String deleteById(@PathVariable Long id)
{
		customerService.deleteById(id);
		return "deleted successfully with id :" +id;
}

@DeleteMapping("/deleteByName/{name}")
public String deleteByName(@PathVariable String name)
{
	customerService.deleteByName(name);
	return "deleted successfully with name :" + name;
}

@GetMapping("/all")
public List<Customer> getAllCustomers()
{
	return customerService.getAllCustomers();
}

@PutMapping("/{id}")
public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer updatedCustomer)
{
	return customerService.updateCustomer(id, updatedCustomer);
}

@PatchMapping("/{id}")
public Customer partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> updates)
{
	return customerService.partialUpdate(id, updates);
}

}
