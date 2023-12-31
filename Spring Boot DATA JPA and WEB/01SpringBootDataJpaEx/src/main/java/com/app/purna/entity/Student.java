package com.app.purna.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name ="Student-tab" )
public class Student {
	
	@Id
	@Column(name = "sid")
	private Integer stdId;
	
	@Column(name = "sname")
	private String stdName;
	
	@Column(name = "sfee")
	private Double stdFee;

}
