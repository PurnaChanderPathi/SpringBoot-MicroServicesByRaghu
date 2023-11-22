package com.app.purna.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.app.purna.service.PdfExportService;

@Configuration
public class AppConfig {
	
	@Bean
	@Profile({"qa","default"})
	public PdfExportService pdf()
	{
		PdfExportService p = new PdfExportService();
		p.setFileExt(".pdf");
		p.setFtype("Document-NPDF");
		return p;
	}
	
}
