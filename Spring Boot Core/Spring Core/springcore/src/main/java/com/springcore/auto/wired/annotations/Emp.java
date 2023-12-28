package com.springcore.auto.wired.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Emp {
	@Autowired
	@Qualifier("address2")
	private Address address;

public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
	System.out.println("Setter");
		this.address = address;
	}
	
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Emp(Address address) {
		super();
		this.address = address;
		System.out.println("Constructor");
	}

	@Override
	public String toString() {
		return "Emp [address=" + address + "]";
	}
}