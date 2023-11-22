package com.app.purna.entity;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usertab")
public class User {
	
	@Id
	@Column(name = "uid")
	private Integer uerid;
	@Column(name = "uname")
	private String userName;
	
	
	@ElementCollection
	@CollectionTable(
			name = "user_roles",
			joinColumns = @JoinColumn(name="uidFK")
			)
	@OrderColumn(name = "uos")//index
	@Column(name = "data")
	List<String> roles;
	

}
