package com.app.purna.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "stdtab")
public class Student {
	@Id
	@Column(name = "sid")
	//@GeneratedValue(strategy = GenerationType.SEQUENCE) //oracle
	@GeneratedValue(strategy = GenerationType.IDENTITY) //mysql(Auto increment)
	//@GeneratedValue(strategy = GenerationType.TABLE) //temp table to store next Pk value
	private Integer stdId;
	@Column(name = "sname")
	private String stdName;
	@Column(name = "sfee")
	private Double stdFee;
	@Column(name = "sdoj")
	//@Temporal(TemporalType.DATE) // stores only date
	//@Temporal(TemporalType.TIME) // stores only time
	@Temporal(TemporalType.TIMESTAMP) // stores only timestamp both time and date
	private Date stdDoj;

}
