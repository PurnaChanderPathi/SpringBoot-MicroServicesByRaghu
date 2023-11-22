package com.app.purna.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_tab")
public class User {
	
	@Id
	@Column(name = "uid" )
	private Integer userId;
	
	@Column(name = "uname" )
	private String userName;
	
	@OneToOne
	//@JoinColumn(name = "ridFk", unique = true,nullable = false)
	@JoinColumn(name = "ridFk", unique = true)
	private Role rob;
}
