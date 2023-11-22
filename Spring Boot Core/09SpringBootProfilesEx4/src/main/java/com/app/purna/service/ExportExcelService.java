package com.app.purna.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

@ToString
@Component
@Profile({"default","qa"})
public class ExportExcelService {
	
	@Value("csv")
	private String extCode;
	@Value("#{new java.util.Random().nextInt()}")
	private Integer formatId;
	
	

}
