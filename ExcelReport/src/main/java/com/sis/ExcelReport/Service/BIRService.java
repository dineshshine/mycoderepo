package com.sis.ExcelReport.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sis.ExcelReport.Model.BirMaster;
import com.sis.ExcelReport.dao.EmployeeDao;

@Service
public class BIRService {

	@Autowired
	EmployeeDao empdao;
	
	@Autowired
	ExcelService exService;
	
	
	public String createDispatchExcel(List<BirMaster> serList) throws IOException {
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet();

		Row rowhead = sheet.createRow(0);

//		headerRow.createCell(0).setCellValue("SC_ENGINEER");
//		headerRow.createCell(1).setCellValue("FRN_NO");
//		headerRow.createCell(2).setCellValue("BRANCH");
//		headerRow.createCell(3).setCellValue("ENGINEER_ID");
//		headerRow.createCell(4).setCellValue("CUST_NAME");
//		headerRow.createCell(5).setCellValue("PRODUCT_MODEL");
//		headerRow.createCell(6).setCellValue("UNIT_STATUS");
//		headerRow.createCell(7).setCellValue("DEF_MOD_BRD_NAME");
//		headerRow.createCell(8).setCellValue("DEF_GIR_NO");
//		headerRow.createCell(9).setCellValue("REP_GIR_NO");
//		headerRow.createCell(10).setCellValue("DEF_UNIT_GIR_NO");
//		headerRow.createCell(11).setCellValue("FINAL_REMARKS");
//		headerRow.createCell(12).setCellValue("DESTINATION");
//		headerRow.createCell(13).setCellValue("SHIPMENT REF NUMBER");
//		headerRow.createCell(14).setCellValue("REF DATE");
		
		
		 rowhead.createCell(0).setCellValue("DIVISION");
			// rowhead.createCell(1).setCellValue("INWARD DATE");
          rowhead.createCell(1).setCellValue("ENTRY DATE");
          rowhead.createCell(2).setCellValue("BIR REF NO.");
          rowhead.createCell(3).setCellValue("SUPPLIER");
          rowhead.createCell(4).setCellValue("MODEL");
          rowhead.createCell(5).setCellValue("CONFIGURATION");
          rowhead.createCell(6).setCellValue("RECEIVED QTY");
          rowhead.createCell(7).setCellValue("FQC REMARKS");
          rowhead.createCell(8).setCellValue("TS TEAM VERIFICATION DATE");
          rowhead.createCell(9).setCellValue("PS TEAM VERIFICATION DATE");
          rowhead.createCell(10).setCellValue("STATUS");
          rowhead.createCell(11).setCellValue("TIMESTAMP");
		
		
		for (int j = 1; j < serList.size(); j++) {
			BirMaster ele = serList.get(j);
			Row dataRow = sheet.createRow(j);
			dataRow.createCell(0).setCellValue(ele.getDivision());
			dataRow.createCell(1).setCellValue(ele.getEntryDate());
			dataRow.createCell(2).setCellValue(ele.getBirRefNo());
			dataRow.createCell(3).setCellValue(ele.getSupplier());
			dataRow.createCell(4).setCellValue(exService.getmodelName(ele.getModel()));
			dataRow.createCell(5).setCellValue(ele.getConfiguration());
			dataRow.createCell(6).setCellValue(ele.getReceivedQty());
			dataRow.createCell(7).setCellValue(ele.getFqcRemarks());
			dataRow.createCell(8).setCellValue(ele.getTsTeamRemark());
			dataRow.createCell(9).setCellValue(ele.getPsTeamRemark());
			dataRow.createCell(10).setCellValue(ele.getFinalStatus());
			dataRow.createCell(11).setCellValue(ele.getCurrentDate().toString());
		}
		
		for (int j = 0; j < rowhead.getPhysicalNumberOfCells(); j++) {
			sheet.autoSizeColumn(j);
		}
		LocalDate ldt1=LocalDate.now();
		////System.out.println("today date issss");
    	
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String formattedString = ldt1.format(formatter);
		String filename="BIRReport'"+formattedString+"'.xlsx";
		FileOutputStream out = new FileOutputStream(new File(filename));
		wb.write(out);
		wb.close();
		out.close();
       return filename;
	}
	
	
	
}
