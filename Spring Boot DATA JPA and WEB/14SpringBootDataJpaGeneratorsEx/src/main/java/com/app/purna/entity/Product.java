package com.app.purna.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.GenericGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_table")
public class Product {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(generator = "test")
	@GenericGenerator(name ="test" ,strategy = "com.app.purna.gen.MyCustomGen")
	@Column(name = "pid")
	private String prodId;
	
	@Column(name = "pname")
	private String prodName;
	
	@Column(name = "pcost")
	private Double prodCost;
}
