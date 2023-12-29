package com.app.purna.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class State {

	@Id
	private Integer stateId;
	private String stateName;
	private Integer countryId;
}
