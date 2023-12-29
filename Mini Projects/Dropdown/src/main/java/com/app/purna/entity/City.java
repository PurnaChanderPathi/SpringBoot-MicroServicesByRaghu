package com.app.purna.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class City {

	@Id
	private Integer cityId;
	private String cityName;
	private Integer stateId;
}
