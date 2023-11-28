package com.app.purna.entity;


import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@JsonProperty("user-unq-id")
	private Integer userId;
	
	@JsonProperty("user-first-name")
	private String userName;
	
	@JsonProperty("user-role")
	private String userRole;
	
	@JsonIgnore
	private String password;
	
	//private List<String> permissons;
	//private String[] permissons;
	private Set<String> permissons;
	
	private Map<String, String> models;
	//private Properties models;
}
