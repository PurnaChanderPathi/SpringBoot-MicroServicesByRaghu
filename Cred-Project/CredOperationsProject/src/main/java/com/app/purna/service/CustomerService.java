package com.app.purna.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.purna.dto.CustomerRequest;
import com.app.purna.entity.Customer;
import com.app.purna.exception.ResourceNotFoundException;
import com.app.purna.repository.CustomerRepository;


@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer saveCustomer(CustomerRequest customerRequest )
	{
		Customer customer = new Customer((long) 0, customerRequest.getName(), customerRequest.getEmail(), customerRequest.getMobile());
		return customerRepository.save(customer);
	}
	
	public Customer findById(Long id)
	{
		return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer with given id :" +id+ " is not found"));
		
	}
	
	public Optional<Customer> findByName(String name)
	{
		Optional<Customer>  findByName = customerRepository.findByName(name);
		  if(findByName.isPresent())
		  {
			  return findByName;
		  }
		  else
		  {
			throw new ResourceNotFoundException("Customer with given id " +name+ " is not found");
		  }
				
	}
	
	public void deleteById(Long id)
	{
		Optional<Customer> findById = customerRepository.findById(id);
		if(findById.isPresent())
		{
			customerRepository.deleteById(id);
		}
		else
		{
			throw new ResourceNotFoundException("Customer with given name :" +id+ " is not found");
		}		
	}
	
	@Transactional
	public void deleteByName(String name)
	{
		Optional<Customer> findByName = customerRepository.findByName(name);
		if(findByName.isPresent())
		{
		customerRepository.deleteByName(name);
		}
		else
		{
			throw new ResourceNotFoundException("Customer with given name :" +name+ " is not found");
		}

	}
	
	public List<Customer> getAllCustomers()
	{
		 return customerRepository.findAll();

	}
	
	@Transactional
	public Customer updateCustomer(Long id, Customer updatedcustomer)
	{
		Optional<Customer> findById = customerRepository.findById(id);
		if(findById.isPresent())
		{
			Customer existingCustomer = findById.get();
			//Replace existing entity properties with updated properties
			BeanUtils.copyProperties(updatedcustomer, existingCustomer,"id");
			return customerRepository.save(existingCustomer);
		}
		else
		{
			throw new ResourceNotFoundException("Customer with id : " +id+ " not Found");
		}

	}
	
	@Transactional
	public Customer partialUpdate(Long id, Map<String, Object> updates)
	{
		Optional<Customer> findById = customerRepository.findById(id);
		
	if(findById.isPresent())
	{
		Customer existingCustomer = findById.get();
				
		//Apply partial update for existing Customer
		for(Map.Entry<String, Object> entry : updates.entrySet())
		{
			String fieldName = entry.getKey();
			Object value = entry.getValue();
			
			setFieldValue(existingCustomer, fieldName, value);
		}
		return customerRepository.save(existingCustomer);
	}
	else
	{
		throw new ResourceNotFoundException("Customer with id : " +id+ " not Found");
	}

	}
	
	private void setFieldValue(Object object, String fieldName, Object value)
	{
		try {
			Field field = object.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			field.set(object, value);
		} catch (NoSuchFieldException | IllegalAccessException e) {
			throw new RuntimeException("Error setting Field" +fieldName+ "on object", e);
		}
	}
}
