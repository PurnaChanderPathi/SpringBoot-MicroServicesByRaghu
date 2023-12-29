package com.app.purna.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Country {

	@Id
	private Integer countryId;
	private String countryName;
}
