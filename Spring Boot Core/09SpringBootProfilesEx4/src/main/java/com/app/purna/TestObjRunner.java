package com.app.purna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.purna.service.ExportExcelService;
import com.app.purna.service.PdfExportService;
@Component
public class TestObjRunner implements CommandLineRunner {
	@Autowired
	private ExportExcelService excelService;
	
	@Autowired
	private PdfExportService exportService;
	
	@Override
	public void run(String... args) throws Exception {
		
			System.out.println(excelService);
			System.out.println(exportService);
	}

}
